package redis;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserInfo implements Serializable {

  /**
   * 
   */
  private static final long   serialVersionUID = -4557644347200037972L;
  private int                 weekNumLimit;
  private Map<String, String> records          = new HashMap<String, String>();

  public int getWeekNumLimit() {
    return weekNumLimit;
  }
  public void setWeekNumLimit(int weekNumLimit) {
    this.weekNumLimit = weekNumLimit;
  }
  public Map<String, String> getRecords() {
    return records;
  }
  public void setRecords(Map<String, String> records) {
    this.records = records;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
