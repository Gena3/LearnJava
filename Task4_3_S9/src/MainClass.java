import Post.*;
import Post.Package;

import java.util.logging.Logger;
import java.lang.*;

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

    public static class StolenPackageException extends RuntimeException{
        public StolenPackageException(){
        }
        public StolenPackageException(String strMessage){
            super(strMessage);
        }
    }

    public static class IllegalPackageException extends RuntimeException{
        public IllegalPackageException(){
        }
        public IllegalPackageException(String strMessage){
            super(strMessage);
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
                MailMessage mailMessage = (MailMessage) mail;
                if((mail.getFrom() == AUSTIN_POWERS) || (mail.getTo() == AUSTIN_POWERS)) {
                    _logger.warning("Detected target mail correspondence: from " + mailMessage.getFrom() + " to " + mailMessage.getTo() + " \"" + mailMessage.getMessage() + "\"");
                }else{
                    _logger.info("Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService{
        private int _iMinPrice;
        private int _iStolenCost;

        public Thief(int iMinPrice){
            _iStolenCost = 0;
            _iMinPrice = iMinPrice;
        }

        public int getStolenValue(){
            return _iStolenCost;
        }

        @Override
        public Sendable processMail(Sendable mail){
            if(mail instanceof MailPackage){
                MailPackage mailPackage = (MailPackage) mail;
                if(mailPackage.getContent().getPrice() >= _iMinPrice){
                    _iStolenCost = _iStolenCost + mailPackage.getContent().getPrice();
                    return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + mailPackage.getContent().getContent(),0));
                }
            }
            return mail;
        }
    }

    public static class Inspector implements MailService{
        @Override
        public Sendable processMail(Sendable mail){
            if(mail instanceof MailPackage){
                MailPackage mailPackage = (MailPackage) mail;
                if (mailPackage.getContent().getContent().contains(WEAPONS) || mailPackage.getContent().getContent().contains(BANNED_SUBSTANCE)){
                    throw new IllegalPackageException("Illegal Package");
                }else if (mailPackage.getContent().getContent().contains("stones")){
                    throw new StolenPackageException("Stolen Package");
                }
            }
            return mail;
        }
    }

    public static void main(String[] args){
        System.out.println("Start");
        // здесь просто проверял. В общем, этот код постоянно менялся. Что осталось, то осталось.
        MailPackage mp1 = new MailPackage(AUSTIN_POWERS, "Me", new Package("Items", 10));
        MailPackage mp2 = new MailPackage("You", "Me", new Package("legal content", 20));
        MailPackage mp3 = null;
        Thief thief = new Thief(25);
        thief.processMail(mp1);
        mp3 = (MailPackage) thief.processMail(mp2);
        Inspector inspector = new Inspector();
        mp3 = (MailPackage) inspector.processMail(mp3);
        System.out.println(mp3.getContent().getContent());
    }
}
