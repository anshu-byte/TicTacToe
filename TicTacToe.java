import java.util.Scanner;
import java.lang.String;
public class TicTacToe {
    static boolean win_x(String [] array)
    {
        String X = "XXX";
        String sample = "";
        int t=0;
        for(int i=0;i<8;i++)
        {
            if(i<=2)
            {
                for (int j=t;j<t+3;j++)
                    sample=sample.concat(array[j]);
                if(sample.equals(X))
                    return true;
                else
                    sample = "";
                t=t+3;
                if(t==9)
                    t=0;
            }
            else if(i<6)
            {
                for (int j=t;j<9;j=j+3)
                    sample=sample.concat(array[j]);
                if(sample.equals(X))
                    return true;
                else
                    sample = "";
                t++;
            }
            else
            {
                for(t=1;t<4;t++)
                    sample=sample.concat(array[4*t-4]);
                if(sample.equals(X))
                    return true;
                else
                    sample = "";
                for(t=1;t<4;t++)
                    sample=sample.concat(array[2*t]);
                if(sample.equals(X))
                    return true;
            }
        }
        return false;
    }

    static boolean win_o(String [] array)
    {
        String O = "OOO";
        String sample = "";
        int t=0;
        for(int i=0;i<8;i++)
        {
            if(i<=2)
            {
                for (int j=t;j<t+3;j++)
                    sample=sample.concat(array[j]);
                if(sample.equals(O))
                    return true;
                else
                    sample = "";
                t=t+3;
                if(t==9)
                    t=0;
            }
            else if(i<6)
            {
                for (int j=t;j<9;j=j+3)
                    sample=sample.concat(array[j]);
                if(sample.equals(O))
                    return true;
                else
                    sample = "";
                t++;
            }
            else
            {
                for(t=1;t<4;t++)
                    sample=sample.concat(array[4*t-4]);
                if(sample.equals(O))
                    return true;
                else
                    sample = "";
                for(t=1;t<4;t++)
                    sample=sample.concat(array[2*t]);
                if(sample.equals(O))
                    return true;
            }
        }
        return false;
    }

    static void display(String [] array) {
        for (int temp=0;temp<9;temp=temp+3)
        {
            for(int i=temp;i<temp+3;i++)
            {
                if(i!=(temp+2))
                {
                    System.out.print(array[i]);
                    System.out.print(" | ");
                }
                else
                    System.out.println(array[i]);
            }
        }
    }

    static boolean check(String [] array,int in)
    {
        return array[in].equals(" ");
    }

    public static void main(String[] args)
    {
        System.out.println("What do you like To Play");
        System.out.println("Two players or Player VS Computer");
        System.out.println("Player X moves first then Player O or Computer");
        System.out.println("For Two Players, Type 1");
        System.out.println("For Player VS Computer, Type 2");

        String[] positions= {" "," "," "," "," "," "," "," "," "};
        Scanner scan = new Scanner(System.in);
        int game_type=scan.nextInt();
        int in;
        if(game_type==1)
        {
            int temp=1;
            for (int t=1;t<=9;t++)
            {
                if(temp%2!=0)
                {
                    System.out.println("Player X, Enter the Position Number");
                    do{in=scan.nextInt();
                    if(check(positions,in-1))
                        positions[in-1]="X";
                    else
                        System.out.println("Please Fill Empty Box");
                    }
                    while(!positions[in-1].equals("X"));
                    display(positions);
                    temp++;
                }
                else
                {
                    System.out.println("Player O, Enter the Position Number");
                    do{in=scan.nextInt();
                        if(check(positions,in-1))
                            positions[in-1]="O";
                        else
                            System.out.println("Please Fill Empty Box");
                    }
                    while(!positions[in-1].equals("O"));
                    display(positions);
                    temp++;
                }

                if(temp>4) {
                    if (win_o(positions)) {
                        System.out.println("O is Winner");
                        break;
                    }
                    else if (win_o(positions)) {
                        System.out.println("X is Winner");
                        break;
                    }
                    else {
                        if (temp == 9) {
                            System.out.println("Match Is Draw");
                            break;
                        }
                    }
                }
            }
        }
        else
        {
            System.out.println("Sorry In Advance, You will not win");
            int temp=1;
            for(int i=1;i<=9;i++)
            {
                System.out.println("Player X, Enter the Position Number");
                do{in=scan.nextInt();
                    if(check(positions,in-1))
                        positions[in-1]="X";
                    else
                        System.out.println("Please Fill Empty Box");
                }
                while(!positions[in-1].equals("X"));
                if(temp!=9){
                    temp++;
                }
                if(temp==9)
                {
                    if(win_x(positions))
                    {
                        System.out.println("Player X is Winner");
                        break;
                    }
                    else
                    {
                        display(positions);
                        System.out.println("Match Is Draw");
                        break;
                    }
                }
                display(positions);
                System.out.print('\n');


                if(temp>=5 && win_x(positions))
                {
                    System.out.println("Player X is Winner");
                    break;
                }
                int computer_position;
                if(temp<5)
                {
                    if(temp==4)
                    {
                        int position_store=0;
                        String[] b =positions.clone();
                        int counter = 0;
                        for(int j=0;j<9;j++) {
                            if (b[j].equals(" ")) {
                                b[j] = "X";
                                if (win_x(b)) {
                                    position_store = j;
                                    counter = 1;
                                    break;
                                } else {
                                    b[j] = " ";
                                }
                            }
                        }
                        if(counter==1)
                        {
                            positions[position_store]="O";
                            temp++;
                            System.out.print("Computer:- ");
                            System.out.println(position_store+1);
                            display(positions);
                            System.out.print('\n');
                        }
                        else
                        {
                            if(check(positions,4))
                                computer_position=4;
                            else if(check(positions,0))
                                computer_position=0;
                            else if (check(positions,2))
                                computer_position=2;
                            else if (check(positions,6))
                                computer_position=6;
                            else if (check(positions,8))
                                computer_position=8;
                            else
                                continue;
                            temp++;
                            System.out.print("Computer:- ");
                            System.out.println(computer_position + 1);
                            positions[computer_position]="O";
                            display(positions);
                            System.out.print('\n');
                        }
                    }
                    else
                    {
                        if(check(positions,4))
                            computer_position=4;
                        else if(check(positions,0))
                            computer_position=0;
                        else if (check(positions,2))
                            computer_position=2;
                        else if (check(positions,6))
                            computer_position=6;
                        else if (check(positions,8))
                            computer_position=8;
                        else
                            continue;
                        temp++;
                        System.out.print("Computer:- ");
                        System.out.println(computer_position + 1);
                        positions[computer_position]="O";
                        display(positions);
                        System.out.print('\n');
                    }
                }
                else
                {
                    int position_=0;
                    String[] a =positions.clone();
                    int counte = 0;
                    for(int j=0;j<9;j++) {
                        if (a[j].equals(" ")) {
                            a[j] = "O";
                            if (win_o(a)) {
                                position_ = j;
                                counte = 1;
                                break;
                            } else {
                                a[j] = " ";
                            }
                        }
                    }
                    if(counte==1)
                    {
                        positions[position_]="O";
                        System.out.print("Computer:- ");
                        System.out.println(position_+1);
                        display(positions);
                        System.out.print('\n');
                        System.out.println("Computer is Winner");
                        break;
                    }
                    int position_store=0;
                    String[] b =positions.clone();
                    int counter = 0;
                    for(int j=0;j<9;j++) {
                        if (b[j].equals(" ")) {
                            b[j] = "X";
                            if (win_x(b)) {
                                position_store = j;
                                counter = 1;
                                break;
                            } else {
                                b[j] = " ";
                            }
                        }
                    }
                    if(counter==0)
                    {
                        do {
                            computer_position = (int) (Math.random() * (9 - 1 + 1) + 1);
                        } while (!positions[computer_position - 1].equals(" "));
                        positions[computer_position-1]="O";
                        temp++;
                        System.out.print("Computer:- ");
                        System.out.println(computer_position);
                        display(positions);
                        System.out.print('\n');
                        if(win_o(positions))
                        {
                            System.out.println("Computer is Winner");
                            break;
                        }
                    }
                    else
                    {
                        positions[position_store]="O";
                        temp++;
                        System.out.print("Computer:- ");
                        System.out.println(position_store+1);
                        display(positions);
                        System.out.print('\n');
                        if(win_o(positions))
                        {
                            System.out.println("Computer is Winner");
                            break;
                        }
                    }
                }
            }
        }
    }
}
