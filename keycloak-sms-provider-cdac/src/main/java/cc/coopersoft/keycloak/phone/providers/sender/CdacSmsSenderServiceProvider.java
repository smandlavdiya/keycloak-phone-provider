package cc.coopersoft.keycloak.phone.providers.sender;

import cc.coopersoft.keycloak.phone.providers.exception.MessageSendException;
import cc.coopersoft.keycloak.phone.providers.spi.FullSmsSenderAbstractService;
import org.jboss.logging.Logger;
import org.keycloak.Config.Scope;

public class CdacSmsSenderServiceProvider extends FullSmsSenderAbstractService {

  private static final Logger logger = Logger.getLogger(CdacSmsSenderServiceProvider.class);
  private final String CdacUsername;
  private final String CdacPassword;
  private final String CdacSenderId;
  private final String CdacSecureKey;
  private final String CdacTemplateId;

  CdacSmsSenderServiceProvider(Scope config, String realmDisplay) {
    super(realmDisplay);
    this.CdacUsername = "mlasia-LokOs";
    this.CdacPassword = "lokossp@DIC244sp";
    this.CdacSenderId = "ILOKOS";
    this.CdacSecureKey = "135b3f72-8e04-4651-b8db-3ec6a43f7bbd";
    this.CdacTemplateId = "1007577570841151371";
  }

  @Override
  public void sendMessage(String phoneNumber, String message) throws MessageSendException {
    SMSService service = new SMSService();
    service.sendSingleSMS(this.CdacUsername, this.CdacPassword, message, this.CdacSenderId, phoneNumber, this.CdacSecureKey, this.CdacTemplateId);
  }

  @Override
  public void close() {
  }
}
