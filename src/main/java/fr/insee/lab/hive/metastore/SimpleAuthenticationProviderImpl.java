package fr.insee.lab.hive.metastore;

import java.util.HashMap;
import java.util.Map;
import javax.security.sasl.AuthenticationException;
import org.apache.hive.service.auth.PasswdAuthenticationProvider;

public class SimpleAuthenticationProviderImpl implements PasswdAuthenticationProvider {

  private final Map<String, String> userMap = new HashMap<>();

  /**
   * @TODO from hiveConf or bcrypt
   */
  public SimpleAuthenticationProviderImpl() {
    init();
  }

  private void init() {
    userMap.put("hiveuser", "hive");
  }

  public void Authenticate(String user, String password) throws AuthenticationException {

    if (!userMap.containsKey(user)) {
      throw new AuthenticationException("Invalid user : " + user);
    }
    if (!userMap.get(user)
                .equals(password)) {
      throw new AuthenticationException("Invalid passwd : " + password);
    }
  }
}
