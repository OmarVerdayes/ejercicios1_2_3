import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

@WebService(name="service", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Service {

    //---------------------------------server del primer ejercicio-------------------------------------
    @WebMethod(operationName = "responsesMessage")
    public  String responsesMessage(@WebParam(name="Numero")String message){
        int num=parseInt(message);
        String men= adivinaN(num);
        return ""+men;
    }
    //---------------------------------server del segundo ejercicio-------------------------------------
    @WebMethod(operationName = "responsesMessage2")
    public  String responsesMessage2(@WebParam(name="Frase")String message){
        String men= consonantes(message);
        return ""+men;
    }
    //---------------------------------server del tercer ejercicio-------------------------------------
    @WebMethod(operationName = "responsesMessage3")
    public  String responsesMessage3(@WebParam(name="apellido1")String apellido1,@WebParam(name="apellido2")String apellido2,@WebParam(name="nombre")String nombre,@WebParam(name="AñoNacimiento")String año, @WebParam(name="MesNacimiento")String mes, @WebParam(name="DiaNacimiento")String dia) {
        String men = RFC( apellido1,  apellido2, nombre,  año,  mes,  dia);
        return "" + men;
    }

    public static void main(String[] args) {
        System.out.println("Inicializando server...");
        Endpoint.publish("http://localhost:8081/Service",new Service());
        System.out.println("Waiting requets...");
    }
//--------------------------------------------------------------ejercicio1---------------------------------
    public String adivinaN(int num){
        Scanner sc=new Scanner(System.in);
        int numR= (int) (Math.random()*10+1);
        int numero=0;
        if (num!=numR){
            return ("No adivinaste");
        }
        return ("Adivinaste");
    }
//--------------------------------------------------------------ejercicio2---------------------------------
    public String consonantes(String frace){
        String consonantes ="";
        String a="a",e="e",i="i",o="o",u="u",A="A",E="E",I="I",O="O",U="U";
        for (int j=0; j<frace.length();j++){
            String l= String.valueOf(frace.charAt(j));
            if (l.equals(a)||l.equals(e)||l.equals(i)||l.equals(o)||l.equals(u)||
                    l.equals(A)||l.equals(E)||l.equals(I)||l.equals(O)||l.equals(U)){
            }else{
                consonantes=consonantes+l;
            }
        }

        return consonantes;
    }
//--------------------------------------------------------------ejercicio3---------------------------------

    public  String RFC(String apellido1, String apellido2,String nombre, String año, String mes, String dia){

        Random random = new Random();
        String rfc="";
        try{
            mes="0"+mes;
            dia="0"+dia;
            char l1=apellido1.charAt(0);
            char l2=apellido1.charAt(1);
            char l3=apellido2.charAt(0);
            char l4=nombre.charAt(0);
            l1 = Character.toUpperCase(l1);
            l2 = Character.toUpperCase(l2);
            l3 = Character.toUpperCase(l3);
            l4 = Character.toUpperCase(l4);
            char l5=año.charAt((año.length()-2));
            char l6=año.charAt((año.length()-1));
            char l7=mes.charAt((mes.length()-2));
            char l8=mes.charAt((mes.length()-1));
            char l9=dia.charAt((dia.length()-2));
            char l10=dia.charAt((dia.length()-1));

            String setOfCharacters = "QWERTYUIOPASDFGHJKLÑZXCVBNM1234567890";

            int r1 = random.nextInt(setOfCharacters.length());
            char l11 = setOfCharacters.charAt(r1);
            int r2 = random.nextInt(setOfCharacters.length());
            char l12 = setOfCharacters.charAt(r2);
            int r3 = random.nextInt(setOfCharacters.length());
            char l13 = setOfCharacters.charAt(r3);
            rfc=l1+""+l2+""+l3+""+l4+""+l5+""+l6+""+l7+""+l8+""+l9+""+l10+""+l11+""+l12+""+l13+"";
        }catch (Exception e){
            System.out.println("se rompio");
        }
        return rfc;
    }

}
