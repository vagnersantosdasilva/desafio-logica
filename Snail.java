
import java.util.ArrayList;
import java.util.List;

public class Snail {

    public static List<Integer> snail(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result; // Retorna lista vazia se a matriz for vazia
        }

        int n = matrix.length;  // Tamanho da matriz N x N
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        
        while (left <= right && top <= bottom) {
            // Percorrer da esquerda para a direita
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Subir uma linha
            
            // Percorrer de cima para baixo
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Mover limite da direita para a esquerda
            
            if (top <= bottom) {
                // Percorrer da direita para a esquerda
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Diminuir limite de baixo
            }
            
            if (left <= right) {
                // Percorrer de baixo para cima
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Mover limite da esquerda para a direita
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Teste com a primeira matriz
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(snail(matrix1));  // Saída: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // Teste com a segunda matriz
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 10, 12},
            {6, 7, 33}
        };
        System.out.println(snail(matrix2));  // Saída: [1, 2, 3, 12, 33, 7, 6, 4, 10]
        
        // Teste com matriz vazia
        int[][] matrixEmpty = {};
        System.out.println(snail(matrixEmpty));  // Saída: []
    }
}

