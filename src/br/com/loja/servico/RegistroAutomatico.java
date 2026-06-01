package br.com.loja.servico;

import br.com.loja.observer.ObserverAction;
import br.com.loja.observer.PedidoObserver;

import java.io.File;
import java.net.URL;

public class RegistroAutomatico {

    /**
     * Utiliza reflexão para encontrar todas as classes no pacote de observadores
     * que possuem a anotação @ObserverAction e as registra no serviço.
     */
    public static void registrarObservadores(ServicoDePedidos servico) {
        String pacote = "br.com.loja.observer";
        String path = pacote.replace('.', '/');
        
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL resource = classLoader.getResource(path);
            
            if (resource == null) return;

            File diretorio = new File(resource.getFile());
            for (File arquivo : diretorio.listFiles()) {
                if (arquivo.getName().endsWith(".class")) {
                    String nomeClasse = pacote + "." + arquivo.getName().replace(".class", "");
                    Class<?> clazz = Class.forName(nomeClasse);

                    if (clazz.isAnnotationPresent(ObserverAction.class) && 
                        PedidoObserver.class.isAssignableFrom(clazz) &&
                        !clazz.isInterface()) {
                        
                        PedidoObserver observer = (PedidoObserver) clazz.getDeclaredConstructor().newInstance();
                        servico.registrar(observer);
                        System.out.println("[REFLEXÃO] Observador registrado: " + clazz.getSimpleName());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("[ERRO] Falha no registro automático: " + e.getMessage());
        }
    }
}
