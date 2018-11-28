package com.featurebim.gui.helper;

import java.net.URI;

import com.featurebim.common.model.enums.EModule;
import com.featurebim.gui.exception.UiCustomizedException;

/**
 * @author rezasei
 *
 */
public interface IUiRestTemplateCall {

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws UiCustomizedException
   */
  <I, O> O callRestPost(final String url,
                        final EModule service,
                        final I edo,
                        final Class<O> response,
                        boolean throwError) throws UiCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @return
   * @throws UiCustomizedException
   */
  <I, O> O callRestPost(final URI url,
                        final EModule service,
                        final I edo,
                        final Class<O> response,
                        boolean throwError) throws UiCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @param args
   * @return
   * @throws UiCustomizedException
   */
  <I, O> O callRestGet(final String url,
                       final EModule service,
                       final Class<O> responseClass,
                       boolean throwError,
                       final Object... args) throws UiCustomizedException;

  /**
   * @param url
   * @param service
   * @param edo
   * @param response
   * @param args
   * @return
   * @throws UiCustomizedException
   */
  <I, O> O callRestGet(final URI url,
                       final EModule service,
                       final Class<O> responseClass,
                       boolean throwError,
                       final Object... args) throws UiCustomizedException;

}
