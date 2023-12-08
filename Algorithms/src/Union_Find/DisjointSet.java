package Union_Find;

import java.util.HashMap;
import java.util.Map;

// Класс для представления непересекающегося множества
class DisjointSet
{
    private Map<Integer, Integer> parent = new HashMap<>();

    // хранит глубину деревьев
    private Map<Integer, Integer> rank = new HashMap<>();

    // выполняем операцию MakeSet
    public void makeSet(int[] universe)
    {
        // создаем `n` непересекающихся наборов (по одному на каждый элемент)
        for (int i: universe)
        {
            parent.put(i, i);
            rank.put(i, 0);
        }
    }

    // Находим корень множества, которому принадлежит элемент `k`
    public int Find(int k)
    {
        // если `k` не является корнем
        if (parent.get(k) != k)
        {
            // сжатие пути
            parent.put(k, Find(parent.get(k)));
        }

        return parent.get(k);
    }

    // Выполняем объединение двух подмножеств
    public void Union(int a, int b)
    {
        // находим корень множеств, в которые входят элементы `x` и `y`
        int x = Find(a);
        int y = Find(b);

        // если `x` и `y` присутствуют в одном наборе
        if (x == y) {
            return;
        }

        // Всегда присоединяйте дерево меньшей глубины под корень более глубокого дерева.
        if (rank.get(x) > rank.get(y)) {
            parent.put(y, x);
        }
        else if (rank.get(x) < rank.get(y)) {
            parent.put(x, y);
        }
        else {
            parent.put(x, y);
            rank.put(y, rank.get(y) + 1);
        }
    }
}
class Main {
    public static void printSets(int[] universe, DisjointSet ds){
        for(int i: universe){
            System.out.print(ds.Find(i) + " ");

        }
        System.out.println();
    }
    // Структура данных Disjoint-Set (алгоритм Union-Find)
    public static void main(String[] args) {
        // вселенная предметов
        int[] universe = {1, 2, 3, 4, 5};
        // инициализируем клас 'DisjointSet'
        DisjointSet disjointSet = new DisjointSet();

        // создаём одно элементный набор для каждого элемента вселенной
        disjointSet.makeSet(universe);
        printSets(universe,disjointSet);

        disjointSet.Union(4, 3); // 4 и 3 находятся в одном наборе
        printSets(universe, disjointSet);

        disjointSet.Union(2, 1);  // 1 и 2 находятся в одном наборе
        printSets(universe, disjointSet);

        disjointSet.Union(1, 3);  // 1, 2, 3, 4 находятся в одном наборе
        printSets(universe, disjointSet);
    }
}
