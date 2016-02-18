/**
The below class was modified from code : Sanfoundry. Java Program To Find MST Using Prims Algorithm; 2015, Available from: http://www.sanfoundry.com/java-program-find-mst-using-prims-algorithm/ [cited 14th August 2015]
 */

package LPGUI;

    import java.util.InputMismatchException;

    import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

     

    public class Prims

    {

        private boolean unsettled[];

        private boolean settled[];

        private int numberofvertices;

        private int adjacencyMatrix[][];

        private int key[];

        public static final int INFINITE = 999;

        private int parent[];

     

        public Prims(int numberofvertices)

        {

            this.numberofvertices = numberofvertices;

            unsettled = new boolean[numberofvertices + 1];

            settled = new boolean[numberofvertices + 1];

            adjacencyMatrix = new int[numberofvertices + 1][numberofvertices + 1];

            key = new int[numberofvertices + 1];

            parent = new int[numberofvertices + 1];

        }

     

        public int getUnsettledCount(boolean unsettled[])

        {

            int count = 0;

            for (int index = 0; index < unsettled.length; index++)

            {

                if (unsettled[index])

                {

                    count++;

                }

            }

            return count;

        }

     

        public void primsAlgorithm(int adjacencyMatrix[][])

        {

            int evaluationVertex;

            for (int source = 1; source <= numberofvertices; source++)

            {

                for (int destination = 1; destination <= numberofvertices; destination++)

                {

                    this.adjacencyMatrix[source][destination] = adjacencyMatrix[source][destination];

                }

            }

     

            for (int index = 1; index <= numberofvertices; index++)

            {

                key[index] = INFINITE;

            }

            key[1] = 0;

            unsettled[1] = true;

            parent[1] = 1;

     

            while (getUnsettledCount(unsettled) != 0)

            {

                evaluationVertex = getMimumKeyVertexFromUnsettled(unsettled);

                unsettled[evaluationVertex] = false;

                settled[evaluationVertex] = true;

                evaluateNeighbours(evaluationVertex);

            }

        } 

     

        private int getMimumKeyVertexFromUnsettled(boolean[] unsettled2)

        {

            int min = Integer.MAX_VALUE;

            int node = 0;

            for (int vertex = 1; vertex <= numberofvertices; vertex++)

            {

                if (unsettled[vertex] == true && key[vertex] < min)

                {

                    node = vertex;

                    min = key[vertex];

                }

            }

            return node;

        }

     

        public void evaluateNeighbours(int evaluationVertex)

        {

     

            for (int destinationvertex = 1; destinationvertex <= numberofvertices; destinationvertex++)

            {

                if (settled[destinationvertex] == false)

                {

                    if (adjacencyMatrix[evaluationVertex][destinationvertex] != INFINITE)

                    {

                        if (adjacencyMatrix[evaluationVertex][destinationvertex] < key[destinationvertex])

                        {

                            key[destinationvertex] = adjacencyMatrix[evaluationVertex][destinationvertex];

                            parent[destinationvertex] = evaluationVertex;

                        }

                        unsettled[destinationvertex] = true;

                    }

                }

            }

        }

     

        public void printMST()

        {
            
            
              String[] ar = { "some", "text", "text"  };
  DefaultTableModel model = new DefaultTableModel(new Object[] { "Source", "Destination", "Weight"},0);
  

            System.out.println("SOURCE  : DESTINATION = WEIGHT");
            int total = 0;
            for (int vertex = 2; vertex <= numberofvertices; vertex++)

            {
                
                total += adjacencyMatrix[parent[vertex]][vertex];
                
                
                System.out.println(parent[vertex] + "\t:\t" + vertex +"\t=\t"+ adjacencyMatrix[parent[vertex]][vertex]);
                Object []d = new Object[]{parent[vertex],vertex,adjacencyMatrix[parent[vertex]][vertex]};
                model.addRow(d);
                
            }
            System.out.println("Total: "+ total);
            Solution s = new Solution(model, total);
            s.setVisible(true);

        }
    }

     

       