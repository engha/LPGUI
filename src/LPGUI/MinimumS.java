package LPGUI;


import static LPGUI.Prims.INFINITE;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MinimumS{
    
 public static void main(String... arg)
    
    {

            int adjacency_matrix[][];

            int number_of_vertices;

            Scanner scan = new Scanner(System.in);

     

            try

            {

                System.out.println("Enter the number of vertices");

                number_of_vertices = scan.nextInt();

                adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];

     

                System.out.println("Enter the Weighted Matrix for the graph");

                for (int i = 1; i <= number_of_vertices; i++)

                {

                    for (int j = 1; j <= number_of_vertices; j++)

                    {

                        adjacency_matrix[i][j] = scan.nextInt();

                        if (i == j)

                        {

                            adjacency_matrix[i][j] = 0;

                            continue;

                        }

                        if (adjacency_matrix[i][j] == 0)

                        {

                            adjacency_matrix[i][j] = INFINITE;

                        }

                    }

                }

     

                Prims prims = new Prims(number_of_vertices);

                prims.primsAlgorithm(adjacency_matrix);

                prims.printMST();

     

            } catch (InputMismatchException inputMismatch)

            {

                System.out.println("Wrong Input Format");

            }

            scan.close();

        }

    }

