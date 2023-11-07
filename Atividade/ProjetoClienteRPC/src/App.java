import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    	//DEFINE A URL DO SERVIDOR
        String urlServ = "http://localhost:8185"; 
        ClienteRPC rpc = new ClienteRPC(urlServ);

        //permite solicitar valores ao usuário
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do{
        //o usuário deve escolher quantas dimenssões a figura possui (padrão de menu para todas as opções)
        System.out.println("\n==========================");
        System.out.println("\nQuantas dimensões possui a figura?");
        System.out.println("\n1 - 2 dimensões.");
        System.out.println("2 - 3 dimensões.");
        System.out.println("0 - Desligar.");
        System.out.println("\nOpção:");
        //escolhi este formato para segregar mais as opções

        opcao = entrada.nextInt(); //solicita um valor ao usuário para escolher a figura
        switch(opcao){
            //como as figuras 2D possuem somente area, o calculo da area ocorre diretamente após a próxima seleção, diferente dos 3D
            case 1:
            System.out.println("opções 2D:");
            System.out.println("\n1 - Area do quadrado.");
            System.out.println("2 - Area do triangulo retangulo.");
            System.out.println("3 - Area do circulo.");
            System.out.println("0 - Sair.");
            System.out.println("\nOpção:");

            int escolha = entrada.nextInt();
                switch (escolha) {

                    //baseado na escolha anterior um dos casos é chamado
                    case 1:
                        System.out.println("\nLado do quadrado:");
                        int lado = entrada.nextInt(); //o lado do quadrado é pedido ao usuário
                        System.out.println("\nA area do quadrado é: " + rpc.AreaQuadrado(lado)); //o rpc chama o ClienteRPC, que por sua vez vai buscar no servidor o calculo
                        break;
                    
                    case 2:
                        //no caso do triangulo o calculo é feito usando 2 valores, portanto são pedidos a base e a altura do triangulo para o calculo
                        System.out.println("\nBase do triangulo:");
                        int base = entrada.nextInt();
                        System.out.println("Altura do triangulo:");
                        int altura = entrada.nextInt();
                        System.out.println("\nA area do triangulo é: " + rpc.AreaTriangulo(base,altura)); /*as respostas finais são todas baseadas no que foi visto em sala,
                        ou seja, todas funcionam da mesma forma, mundando apenas o valor que recebem*/
                        break;

                    case 3:
                        //mesma estrutura do quadrado mudando o lado pelo raio do circulo
                        System.out.println("\nRaio do circulo:");
                        int raio = entrada.nextInt();
                        System.out.println("\nA area do circulo é: " + rpc.AreaCircunferencia(raio));
                        break;
                
                    case 0:
                        //caso digite 0 o programa se encerra
                        break;
                    
                    default: //mensagem padrão quando o número digitado é inválido, retorna o programa para o menu inicial
                        System.out.println("\nValor inválido! Reiniciando...\n");
                        System.out.println("==========================\n");
                        break;
                }
            break;

            case 2:
            //no caso das figuras 3D é escolhido apenas qual a figura se deseja calcular
            System.out.println("opções 3D:");
            System.out.println("\n1 - Cilindro.");
            System.out.println("2 - Esfera.");
            System.out.println("3 - Cubo.");
            System.out.println("0 - Sair.");
            System.out.println("\nOpção:");

            escolha = entrada.nextInt();
                switch (escolha) {
                    case 1:
                        //após a escolha outro menu aparece e pede o calculo desejado
                        System.out.println("\nOpções de calculo do cilindro:");
                        System.out.println("1 - volume.");
                        System.out.println("2 - area.");
                        System.out.println("3 - ambos."); //para todos os objetos 3D existe esta opção caso se queira saber a area e o volume simultaneamente
                        System.out.println("0 - sair.");
                        System.out.println("\nOpção:");

                        int x = entrada.nextInt();
                            switch (x) {
                                case 1:
                                    //na escolha de 1 ele calcula o volume
                                    //no caso do cilindro ele necessita de 2 valores que são requiridos na sequencia
                                    System.out.println("\nDigite o raio do cilindro:");
                                    int raio = entrada.nextInt();
                                    System.out.println("Digite a altura do cilindro:");
                                    int altura = entrada.nextInt();
                                    System.out.println("\nO volume do cilindro é: " + rpc.VolumeCilindro(raio,altura));
                                    break;

                                case 2:
                                    //na escolha de 2 ele calcula a area
                                    System.out.println("\nDigite o raio do cilindro:");
                                    raio = entrada.nextInt();
                                    System.out.println("Digite a altura do cilindro:");
                                    altura = entrada.nextInt();
                                    System.out.println("\nA area do cilindro é: " + rpc.AreaCilindro(raio,altura));
                                    break;

                                case 3:
                                    //na escolha de 3 ele pede o raio e a altura para calcular tanto a area quanto o volume
                                    System.out.println("\nDigite o raio do cilindro:");
                                    raio = entrada.nextInt();
                                    System.out.println("Digite a altura do cilindro:");
                                    altura = entrada.nextInt();
                                    System.out.println("\nA area do cilindro é: " + rpc.AreaCilindro(raio,altura));
                                    System.out.println("\nO volume do cilindro é: " + rpc.VolumeCilindro(raio,altura));
                                    break;
                            
                                case 0:
                                    break;

                                default:
                                    System.out.println("\nValor inválido! Reiniciando...\n");
                                    System.out.println("==========================\n");
                                    break;
                                }
                            break;
                    
                    case 2:
                        //estrutura identica a do cilindro com as adaptações necessárias para o calculo da esfera
                        System.out.println("\nOpções de calculo da esfera:");
                        System.out.println("1 - volume.");
                        System.out.println("2 - area.");
                        System.out.println("3 - ambos.");
                        System.out.println("0 - sair.");
                        System.out.println("\nOpção:");

                        x = entrada.nextInt();
                            switch (x) {
                                    case 1:
                                        System.out.println("\nDigite o raio da esfera:");
                                        int raio = entrada.nextInt();
                                        System.out.println("\nO volume da esfera é: " + rpc.VolumeEsfera(raio));
                                        break;

                                    case 2:
                                        System.out.println("\nDigite o raio da esfera:");
                                        raio = entrada.nextInt();
                                        System.out.println("\nA area da esfera é: " + rpc.AreaEsfera(raio));
                                        break;

                                    case 3:
                                        System.out.println("\nDigite o raio da esfera:");
                                        raio = entrada.nextInt();
                                        System.out.println("\nA area da esfera é: " + rpc.AreaEsfera(raio));
                                        System.out.println("\nO volume da esfera é: " + rpc.VolumeEsfera(raio));
                                        break;
                                
                                    case 0:
                                        break;

                                    default:
                                        System.out.println("\nValor inválido! Reiniciando...\n");
                                        System.out.println("==========================\n");
                                        break;
                                }
                            break;
                        

                    case 3:
                        //a mesma estrutura novamente e com os valores necessários para o cubo
                        System.out.println("\nOpções de calculo do cubo:");
                        System.out.println("1 - volume.");
                        System.out.println("2 - area.");
                        System.out.println("3 - ambos.");
                        System.out.println("0 - sair.");
                        System.out.println("\nOpção:");

                        x = entrada.nextInt();
                            switch (x) {
                                    case 1:
                                        System.out.println("\nDigite o lado do cubo:");
                                        int lado = entrada.nextInt();
                                        System.out.println("\nO volume do cubo é: " + rpc.VolumeCubo(lado));
                                        break;

                                    case 2:
                                        System.out.println("\nDigite o lado do cubo:");
                                        lado = entrada.nextInt();
                                        System.out.println("\nA area do cubo é: " + rpc.AreaCubo(lado));
                                        break;

                                    case 3:
                                        System.out.println("\nDigite o lado do cubo:");
                                        lado = entrada.nextInt();
                                        System.out.println("\nA area do cubo é: " + rpc.AreaCubo(lado));
                                        System.out.println("\nO volume do cubo é: " + rpc.VolumeCubo(lado));
                                        break;
                                
                                    case 0:
                                        break;

                                    default:
                                        System.out.println("\nValor inválido! Reiniciando...\n");
                                        System.out.println("==========================\n");
                                        break;
                                }
                            break;
                    }
                break;
                case 0:
                    //sai do menu e encerra o programa
                    System.out.println("Desligando...");
                    break;

                default:
                    System.out.println("\nValor inválido! Reiniciando...\n");
                    System.out.println("==========================\n");
                    break;
            }
        }while(opcao != 0);
    //confirmação que o programa chegou ao fim
    System.out.println("===========================");
    System.out.println("O aplicativo foi desligado!");
    System.out.println("===========================");
    }
}