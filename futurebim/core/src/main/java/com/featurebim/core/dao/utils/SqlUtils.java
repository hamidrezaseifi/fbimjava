package com.featurebim.core.dao.utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SqlUtils {

  public static LocalDateTime getDatetimeFromTimestamp(final Timestamp timestamp) {

    if (timestamp != null) {
      return timestamp.toLocalDateTime();
    }
    return null;
  }

  public static LocalDate getDateFromTimestamp(final Timestamp timestamp) {

    if (timestamp != null) {
      return timestamp.toLocalDateTime().toLocalDate();
    }
    return null;
  }
  
}
