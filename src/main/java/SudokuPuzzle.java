import java.io.File;

public class SudokuPuzzle {
    public static void main(String[] args) throws Exception {
        if (args[0].equals("-h")) {
            System.out.println("Type valid command line argument as: <input file name> <output file name>");
        } else {
            String outputFile=null;
            if(args.length==2){
                outputFile= args[1];
            }
            SudokuSolver sudokuSolver= new SudokuSolver(args[0],outputFile);
            String sudokuArray[][] = sudokuSolver.getSudokuBoard();
            String sudokuBoard[][] = sudokuSolver.getSudokuBoard();
            int backTrackingCount = 0;
            int onePossibleCount = 0;
            int humanKindCount = 0;
            sudokuSolver.checkValidity(sudokuBoard, sudokuBoard[0].length);
            long startTime = System.nanoTime();

            OnePossibleSolution onePossibleSolution = new OnePossibleSolution(sudokuBoard);
            long startTime1 = System.nanoTime();
            onePossibleSolution.solveSudoku();
            long endTime1 = System.nanoTime();
            long totalTimeTaken1 = endTime1 - startTime1;
            onePossibleSolution.display();
            onePossibleCount = onePossibleSolution.getOnePossibleSolutionCount();
            sudokuBoard = onePossibleSolution.getGameBoard();
            HumanKind humanKind = new HumanKind(sudokuBoard);
            long startTime2 = System.nanoTime();
            humanKind.solveSudoku();
            long endTime2 = System.nanoTime();
            long totalTimeTaken2 = endTime2 - startTime2;
            humanKind.display();
            humanKindCount = humanKind.getHumanKindCount();
            sudokuBoard = humanKind.getGameBoard();
            BackTracking backTracking = new BackTracking(sudokuBoard);
            long startTime3 = System.nanoTime();
            backTracking.solveSudoku();
            long endTime3 = System.nanoTime();
            long totalTimeTaken3 = endTime3 - startTime3;
            backTrackingCount = backTracking.getBackTrackingCount();
            sudokuBoard = backTracking.getGameBoard();
            backTracking.display();
            long endTime = System.nanoTime();
            long totalTimeTaken = endTime - startTime;

            if (args.length == 2) {
                File fout = new File(args[1]);
//                new FileIO(fout, sudokuBoard, onePossibleCount, humanKindCount, backTrackingCount, totalTimeTaken, totalTimeTaken1, totalTimeTaken2, totalTimeTaken3);
                sudokuSolver.writeFile(fout, sudokuBoard, onePossibleCount, humanKindCount, backTrackingCount, totalTimeTaken, totalTimeTaken1, totalTimeTaken2, totalTimeTaken3);
            } else {
                System.out.println(String.valueOf(sudokuArray[0].length));
                System.out.println();
                for (int i = 0; i < sudokuArray[0].length + 1; i++) {
                    for (int j = 0; j < sudokuArray[0].length ; j++) {
                        if (sudokuArray[i][j].equals("0")) {
                            System.out.print("-");
                            System.out.print(" ");
                        } else {
                            System.out.print(sudokuArray[i][j]);
                            System.out.print(" ");
                        }
                    }
                    System.out.println();

                }

                System.out.println();
                System.out.println();
                System.out.print("Solution:");
                System.out.println();
                System.out.println();

                for (int i = 1; i < sudokuBoard[0].length + 1; i++) {
                    for (int j = 0; j < sudokuBoard[0].length; j++) {
                        System.out.print(sudokuBoard[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println();

                System.out.print("Total Time:   ");
                System.out.print(String.valueOf(totalTimeTaken)+"   ns");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.print("Strategy               ");
                System.out.print("Uses          ");
                System.out.print("Time   ");
                System.out.println();
                System.out.print("One Possible Solution  ");
                System.out.print(onePossibleCount+"      ");
                System.out.print(String.valueOf(totalTimeTaken1)+"  ns");
                System.out.println();
                System.out.print("Human Kind Strategy    ");
                System.out.print(humanKindCount+"      ");
                System.out.print(String.valueOf(totalTimeTaken2)+"  ns");
                System.out.println();
                System.out.print("BackTracking           ");
                System.out.print(backTrackingCount+"      ");
                System.out.print(String.valueOf(totalTimeTaken3)+"  ns");

            }
        }
    }

}