import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static char columA = 'A',  columB = 'B',  columC = 'C',  columD = 'D', columE = 'E', columF = 'F';
    static int lines = 7;
    static int colum = 6;
    static char[][] camp = new char[lines][colum];
    static int[] n = new int[lines];
    static int boats = 11;
    static char[][] target = {
            {'-','+','+','+','-','+'},
            {'-','+','+','+','+','-'},
            {'+','+','-','+','+','-'},
            {'+','+',' ','+','+','+'},
            {'+','+','-','-','-','+'},
            {'+','-','+','+','+','+'},
            {'-','+','+','+','+','+'}
    };

    static int[][] columsIntX = {
            {1,2,3,4,5,6}
    };

    static int[][] columsIntY = {
            {1},{2},{3},{4},{5},{6},{7}
    };

    public static void main(String[] args) {
        System.out.println();
        System.out.println("------------- Batalha Naval com Matrizes -------------");
        System.out.println();
        System.out.println("Temos 11 Inimigos para serem abatidos!");
        System.out.println();
        System.out.println(" 0  | "+ columA +" | "+ columB +" | "+ columC +" | "+columD+" | "+ columE +" | "+ columF +" | ");

        for (int i = 0; i < lines; i++) {
            n[i] = i + 1;

            System.out.print(" " + n[i] + "  |");

            for (int j = 0; j < colum; j++) {
                camp[i][j] = ' ';
                System.out.print(" " + camp[i][j] + " |");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("ⓘ Utilize as coordenadas corretamente. Ex:(B3, A7, D2)");

        while(true){
            System.out.println();
            char columX;
            int y = 0;

            System.out.print("Target (x,y): ");
            //columX = input.next().charAt(0);
            String msg = input.nextLine().toUpperCase();
            columX = msg.charAt(0);
            int x = 0;
            boolean checkColum = columX == columA || columX == columB || columX == columC || columX == columD || columX == columE || columX == columF;

            if(!checkColum){
                System.out.println();
                System.out.println("Esta coluna não existe!");
                continue;
            }

            if(columX == columA){
                x = 0;
            }else if(columX == columB){
                x = 1;
            }else if(columX == columC){
                x = 2;
            }else if(columX == columD){
                x = 3;
            }else if(columX == columE){
                x = 4;
            }else if(columX == columF){
                x = 5;
            }

            int i;
            if(msg.length() == 2){
                for (i = 0; i < msg.length(); i++) {
                    if (Character.isDigit(msg.charAt(i))) {
                        break;
                    }
                }
            }else{
                System.out.println();
                System.out.println("Coordenadas inválidas!");
                continue;
            }


            try{
                y = Integer.parseInt(msg.substring(i));
            }catch (NumberFormatException e){
                System.out.println();
                System.out.println("Número inválido!");
            }

            int columY = 0;

            if(y < 1){
                System.out.println();
                System.out.println("Não temos acesso a essa area!");
                continue;
            }else{
                columY = y - 1;
            }

            System.out.println();

            camp[columY][x] = '-';
            boolean hit = false;

            if(camp[columY][x] == target[columY][x]){
                if(camp[columY][x] == 'X'){
                    camp[columY][x] = 'X';
                }else{
                    camp[columY][x] = 'X';
                    hit = true;
                }
            }

            if(hit){
                System.out.println("BOOOM! Acertou o navio na posição " + columX + " | " + y);
            }else{
                System.out.println("Não acertou nenhum navio! "+ columX + " | " + y);
            }

            ShowCamp();
        }

    }

    public static void ShowCamp(){
        System.out.println();
        System.out.println(" 0  | "+ columA +" | "+ columB +" | "+ columC +" | "+columD+" | "+ columE +" | "+ columF +" | ");

        for (int i = 0; i < lines; i++) {
            n[i] = i + 1;

            System.out.print(" " + n[i] + "  |");

            for (int j = 0; j < colum; j++) {
                System.out.print(" " + camp[i][j] + " |");
            }
            System.out.println();
        }
    }

}