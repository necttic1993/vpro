//<editor-fold defaultstate="collapsed" desc=" ZONA DE PAQUETES ">

package backup;

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" ZONA DE IMPORTACIONES ">

import java.util.Date;
import javax.mail.Message;
import javax.mail.Session;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" CLASE ">

public class SendEmail 
{

    //<editor-fold defaultstate="collapsed" desc=" ZONA DE VAR GLOBALES ">
    
    public static String GlobalHoraActualString;
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc=" ZONA DE CONSTRUCTOR ">
    public SendEmail( String HoraActualString) 
    {
    
        GlobalHoraActualString = HoraActualString;

    }// FIN CONSTRUCTOR

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" METODOS PRINCIPAL ">
    
    public static void main( String[] args ) 
    {
        
         final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        
        // CONSIGUE PROPIEDADES DEL OBJETO.-
        //----------------------------------------------------------------------
            Properties props = System.getProperties();
            
            props.setProperty( "mail.smtp.host"                  , "smtp.gmail.com" );
            props.setProperty( "mail.smtp.socketFactory.class"   , SSL_FACTORY      );
            props.setProperty( "mail.smtp.socketFactory.fallback", "false"          );
            props.setProperty( "mail.smtp.port"                  , "465"            );
            props.setProperty( "mail.smtp.socketFactory.port"    , "465"            );
            props.put(         "mail.smtp.auth"                  , "true"           );
            props.put(         "mail.debug"                      , "true"           );
            props.put(         "mail.store.protocol"             , "pop3"           );
            props.put(         "mail.transport.protocol"         , "smtp"           );
            
            // SE DEFINE NOMBRE DEL EMISOR Y PASSWORD.-
                final String username = "valecarlos093@gmail.com";
                final String password = "ValienteRegis1993@1";
        //----------------------------------------------------------------------
              
        //<editor-fold defaultstate="collapsed" desc=" TRY ">
            
        try
        {
            
            // AUTENTICACION DE USUARIO.-
                Session session = Session.getDefaultInstance
                (
                    props, 
                    new Authenticator()
                    {
                        protected PasswordAuthentication getPasswordAuthentication() 
                        {
                            
                            return new PasswordAuthentication( username, password );
                            
                        }// FIN METODO ANIDADO
                        
                    }// FIN METODO CONSTRUCTOR
                );

            // CREA UN NUEVO MENSAJE.-
                Message msg = new MimeMessage( session );

            // CONFIGURA CAMPO DE TEXTO EMISOR.-                
                msg.setFrom( new InternetAddress( "valecarlos093@gmail.com" ) );
                
            // CONFIGURA CAMPO DE TEXTO DESTINATARIO.-                                
                msg.setRecipients
                (
                        
                    Message.RecipientType.TO, 
                    InternetAddress.parse( "valecarlos093@gmail.com", false ) 
                                            //robertogaona1234@gmail.com
                        
                );
                
            // CONFIGURA EL CAMPO DE TEXTO ASUNTO.-                
                msg.setSubject( "Mensaje Importante" );

            // SE REDACTA EL TEXTO A ENVIARSE.-                
                msg.setText( "Copia de seguridad" );
                
            // SE ENVIA FECHA DE ENVIO DEL MENSAJE.-                                
                msg.setSentDate( new Date() );

//------------------------------------------------------------------------------
            // Create the message part 
                BodyPart messageBodyPart = new MimeBodyPart();
                
            // Create a multipar message
                Multipart multipart = new MimeMultipart();

            // Part two is attachment
                messageBodyPart = new MimeBodyPart();
                String filename = "C:\\copia\\ElNro_" + GlobalHoraActualString +".sql";
                
                DataSource source = new FileDataSource( filename );
                messageBodyPart.setDataHandler( new DataHandler( source ) );
                messageBodyPart.setFileName( filename );
                multipart.addBodyPart( messageBodyPart );

            // Send the complete message parts
                msg.setContent( multipart );                
//------------------------------------------------------------------------------                
         
            // SE ENVIA EL MENSAJE.-                                                
                Transport.send( msg );
                
            // MENSAJE AL ANALISTA.-
                System.out.println( "Mensaje enviado." );

        }// FIN TRY
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc=" CATCH ">
        
        catch ( MessagingException e )
        { 
            
            // MENSAJE AL ANALISTA.-
                System.out.println( "Error de envio, causado por: " + e );
                
        }// FIN CATCH

        //</editor-fold>                
        
    }// FIN METODO PRINCIPAL

    //</editor-fold>   
  
}// FIN CLASE

//</editor-fold>

