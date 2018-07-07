package de.tui.cssi.mdmui.bl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import de.tui.cssi.mdm.common.enums.EErrorResponses;
import de.tui.cssi.mdm.common.enums.ESourceSystems;
import de.tui.cssi.mdm.common.enums.ETenants;
import de.tui.cssi.mdm.common.exceptions.UnknownEnumValueException;
import de.tui.cssi.mdm.common.model.CustomerEdo;
import de.tui.cssi.mdm.common.model.CustomerQueryEdo;
import de.tui.cssi.mdm.common.rest.CustomerReadErrorResponse;
import de.tui.cssi.mdm.common.rest.CustomerSearchErrorResponse;
import de.tui.cssi.mdm.common.rest.ErrorResponse;
import de.tui.cssi.mdmui.exception.CustomerNotFoundException;
import de.tui.cssi.mdmui.exception.CustomerSaveException;
import de.tui.cssi.mdmui.exception.CustomerVersionException;
import de.tui.cssi.mdmui.helpers.MessagesHelper;
import de.tui.cssi.mdmui.helpers.UiConfiguration.MdmCoreConfig;
import de.tui.cssi.mdmui.mapper.UiCustomerEdoMapper;
import de.tui.cssi.mdmui.model.customer.UiCustomer;
import de.tui.cssi.mdmui.model.customer.UiCustomerReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * exchange customers data with core through core Customer rest service
 *
 * @author rezasei
 *
 */
/**
 * @author rezasei
 *
 */
@Component
public class CustomerListHandler {

  private final Logger logger = LoggerFactory.getLogger(CustomerListHandler.class);

  @Autowired
  private MdmCoreConfig mdmCoreConfig;

  @Autowired
  MessagesHelper messages;

  /**
   * get list of customer data from core filter by query items
   *
   *
   * @param query
   * @return
   * @throws UnknownEnumValueException
   */
  public List<UiCustomer> searchCustomers(final CustomerQueryEdo query) throws UnknownEnumValueException,
                                                                        IOException,
                                                                        ResourceAccessException,
                                                                        URISyntaxException {

    logger.debug("Mapping UiQueryModel in Xml and send to MDM and receive the customers list");

    List<UiCustomer> listCustomers = new ArrayList<>();

    final HttpEntity<CustomerQueryEdo> requestEntity = new HttpEntity<>(query);

    final RestTemplate restTemplate = new RestTemplate();
    final ResponseEntity<CustomerSearchErrorResponse> responseEntity = restTemplate.exchange(mdmCoreConfig.getCustomerSearchUri(),
                                                                                             HttpMethod.POST,
                                                                                             requestEntity,
                                                                                             CustomerSearchErrorResponse.class);

    if (responseEntity != null && responseEntity.hasBody()) {

      final CustomerSearchErrorResponse responseBody = responseEntity.getBody();
      if (responseBody.getErrorType() == EErrorResponses.SUCCESS) {
        if (responseBody.getCustomers() != null) {
          listCustomers = UiCustomerEdoMapper.fromCustomerEdoList(responseBody.getCustomers());
        }
      }
      else {
        throw new CustomerNotFoundException(messages.get("error.customersearcherror"));
      }

    }
    else

    {
      this.logger.error("Expected body in response but not found.");
    }

    return listCustomers;
  }

  /**
   * get customer detail
   *
   * @param sourceSystem
   * @param sourceSystemCustomerId
   * @param tenantKey
   * @return
   * @throws UnknownEnumValueException
   * @throws IOException
   * @throws ResourceAccessException
   * @throws URISyntaxException
   * @throws CustomerNotFoundException
   */
  public UiCustomer getCustomer(final ESourceSystems sourceSystem,
                                final String sourceSystemCustomerId,
                                final ETenants tenantKey) throws UnknownEnumValueException,
                                                          IOException,
                                                          ResourceAccessException,
                                                          URISyntaxException,
                                                          CustomerNotFoundException {

    logger.debug("get the customers for the given id");

    final RestTemplate restTemplate = new RestTemplate();

    String url = mdmCoreConfig.getCustomerGetPath() + "/"
                 + sourceSystem.getValueName()
                 + "/"
                 + sourceSystemCustomerId
                 + "/"
                 + tenantKey.getValueName();
    url = url.replace("//", "/").replace(":/", "://");

    logger.debug("url: " + url);

    final CustomerReadErrorResponse responseBody = restTemplate.getForObject(url,
                                                                             CustomerReadErrorResponse.class);
    if (responseBody.getCustomerEdo() == null || responseBody.getErrorType() != EErrorResponses.SUCCESS) {
      throw new CustomerNotFoundException(messages.get("error.customergeterror"));
    }

    final UiCustomer customer = UiCustomerEdoMapper.fromCustomerEdo(responseBody.getCustomerEdo());

    return customer;
  }

  /**
   * save customer data to core for saving in database
   *
   *
   * @param customer
   * @return
   * @throws URISyntaxException
   * @throws IOException
   */
  public boolean save(final UiCustomer customer) throws UnknownEnumValueException,
                                                 IOException,
                                                 ResourceAccessException,
                                                 URISyntaxException,
                                                 CustomerVersionException,
                                                 CustomerSaveException {

    logger.debug("Mapping UiCustomer in Xml and send to MDM and receive the saving response");

    final CustomerEdo customerEdo = UiCustomerEdoMapper.toCustomerEdo(customer);
    final HttpEntity<CustomerEdo> requestEntity = new HttpEntity<>(customerEdo);

    final RestTemplate restTemplate = new RestTemplate();
    final ResponseEntity<ErrorResponse> responseEntity = restTemplate.exchange(mdmCoreConfig.getCustomerSaveUri(),
                                                                               HttpMethod.POST,
                                                                               requestEntity,
                                                                               ErrorResponse.class);

    if (responseEntity != null && responseEntity.hasBody()) {
      final ErrorResponse responseBody = responseEntity.getBody();

      if (responseBody.getErrorType() != EErrorResponses.SUCCESS) {

        if (responseBody.getErrorType() == EErrorResponses.RECORD_VERSION_MISMATCH
            || responseBody.getErrorType() == EErrorResponses.OPTIMISTIC_LOCKING_FAILURE) {
          throw new CustomerVersionException(messages.get("error.oldrecordreload"));
        }
        if (responseBody.getErrorType() == EErrorResponses.CUSTOMER_NOT_SAVED) {
          this.logger.error("core could not save the customer recotd.");
          throw new CustomerSaveException(messages.get("error.saveerror"));
        }
      }
    }
    else {
      this.logger.error("Expected body in response but not found.");
      throw new CustomerSaveException(messages.get("error.saveerror"));
    }
    return true;
  }

  /**
   * get list of related customers from three id
   *
   * @param sourceSystem
   * @param sourceSystemCustomerId
   * @param tenantKey
   * @return
   * @throws UnknownEnumValueException
   * @throws IOException
   * @throws ResourceAccessException
   * @throws URISyntaxException
   * @throws CustomerNotFoundException
   */
  public List<UiCustomer> getRelatedCustomerListFromIds(final ESourceSystems sourceSystem,
                                                        final String sourceSystemCustomerId,
                                                        final ETenants tenantKey) throws UnknownEnumValueException,
                                                                                  IOException,
                                                                                  ResourceAccessException,
                                                                                  URISyntaxException,
                                                                                  CustomerNotFoundException {

    logger.debug("get list of related customers from three id {} {} {}", sourceSystem, sourceSystemCustomerId, tenantKey);

    final UiCustomer customer = getCustomer(sourceSystem, sourceSystemCustomerId, tenantKey);

    final List<UiCustomer> list = new ArrayList<>();
    for (final UiCustomerReference rCustomer : customer.getRelatedCustomers()) {
      list.add(getCustomer(rCustomer.getSourceSystem(),
                           rCustomer.getSourceSystemCustomerId(),
                           rCustomer.getTenant()));
    }

    return list;
  }

  /**
   * get list of related customers from three id
   *
   * @param sourceSystem
   * @param sourceSystemCustomerId
   * @param tenantKey
   * @return
   * @throws UnknownEnumValueException
   * @throws IOException
   * @throws ResourceAccessException
   * @throws URISyntaxException
   * @throws CustomerNotFoundException
   */
  public List<UiCustomer> getRelatedCustomerListFromCustomer(final UiCustomer customer) throws UnknownEnumValueException,
                                                                                        IOException,
                                                                                        ResourceAccessException,
                                                                                        URISyntaxException,
                                                                                        CustomerNotFoundException {

    logger.debug("get the customers for the given customer {}", customer.toString());

    final List<UiCustomer> list = new ArrayList<>();
    for (final UiCustomerReference rCustomer : customer.getRelatedCustomers()) {
      list.add(getCustomer(rCustomer.getSourceSystem(),
                           rCustomer.getSourceSystemCustomerId(),
                           rCustomer.getTenant()));
    }

    return list;
  }
}
