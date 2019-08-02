import Post.*;

import java.util.logging.Logger;

public class MainClass {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public  interface MailService {
        Sendable processMail(Sendable mail);
    }

    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }


    public static class UntrustworthyMailWorker implements MailService{
        private RealMailService _realMailService;
        private MailService[] _mailServices = null;

        public UntrustworthyMailWorker(MailService[] mailServices){
            _realMailService = new RealMailService();
            if (mailServices.length > 0){
                this._mailServices = new MailService[mailServices.length];
                _mailServices = mailServices.clone();
            }
        }

        public RealMailService getRealMailService(){
            return _realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail){
            Sendable senRetValue = mail;
            for(int i = 0; i < this._mailServices.length; i++){
                senRetValue = this._mailServices[i].processMail(senRetValue);
            }
            return _realMailService.processMail(senRetValue);
        }
    }

    public static class Spy implements MailService{
        Logger _logger;

        public Spy(Logger logger){
            _logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail){
            if (mail instanceof MailMessage){
                if((mail.getFrom() == AUSTIN_POWERS) || (mail.getTo() == AUSTIN_POWERS)) {
                    _logger.warning("Detected target mail correspondence: from " + mail.getFrom() + " to " + mail.getTo() + " \"" + mail.getMessage() + "\"");
                }else{
                    _logger.info("Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService{

        @Override
        public Sendable processMail(Sendable mail){
            return mail;
        }
    }

    public static void main(String[] args){

        System.out.println("Start");
    }
}
