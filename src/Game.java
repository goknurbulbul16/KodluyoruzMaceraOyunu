import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera Oyununa Hoşgeldin.");
        System.out.print("Lütfen isimini gir: ");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        System.out.println( "Hoşgeldin "+player.getName());
        System.out.println();
        System.out.println("Oyuna Başlamak için karakter seç lütfen.");
        player.selectChar();
        System.out.println("----------------------------------------------------------------------------------");


        Location location = null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("------ Bölgeler ------\n");
            System.out.println("1. Güvenli Ev");
            System.out.println("2. Mağaza");
            System.out.println("3. Mağara --> Ödül: <Yemek>");
            System.out.println("4. Orman ---> Ödül: <Odun>");
            System.out.println("5. Nehir ---> Ödül: <Su>");
            System.out.println("0. Çıkış Yap");
            System.out.println();
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz:  ");
            int selectLoc = input.nextInt();

            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge seçiniz.");
            }
            if(location == null){
                System.out.println("Çıkış Yapıldı !");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Game Over !");
                break;
            }

        }
    }
}
