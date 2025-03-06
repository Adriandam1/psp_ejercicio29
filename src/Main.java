import java.security.Provider;
import java.security.Security;
import java.security.Provider.Service;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Listamos los proveedores de seguridad
        Provider[] providers = Security.getProviders();

        // Recorremos los proveedores
        for (Provider provider : providers) {
            // Obtenemos los servicios del proveedor
            Set<Service> services = provider.getServices();
            System.out.println("Proveedor: " + provider.getName()+"\n\tServicios que correspondan a algoritmos de hash (MessageDigest) :");

            // Recorremos los servicios
            for (Service service : services) {
                // Si el servicio es de tipo MessageDigest
                if ("MessageDigest".equals(service.getType())) {
                    // Imprimimos el algoritmo
                    System.out.println("\t\t"+service.getAlgorithm());
                    //System.out.println("Proveedor: " + provider.getName()+"\nServicio: "+service.getAlgorithm());
                }
            }
        }

    }
}