package algorithm.tree;

/**
 * 判断是否为搜索二叉树的后序遍历
 * @Author zp
 * @create 2020/12/25 10:34
 */
public class VerifyLastSeqTree {
    public static void main(String[] args) {
//        int[] arr = {1,2,5,10,6,9,4,3};
        int[] arr = {179, 437, 1405, 5227, 8060, 8764, 8248, 4687, 3297, 13038, 12691, 15744, 16195, 15642, 19813, 17128, 21051, 20707, 22177, 21944, 23644, 23281, 19970, 23652, 26471, 31467, 33810, 32300, 33880, 27334, 25987, 35643, 35103, 36489, 42534, 42990, 42942, 37090, 36075, 34516, 16624, 11335, 10737, 44641, 45754, 47096, 46021, 49150, 48013, 49814, 51545, 52555, 50701, 47875, 56783, 57558, 53812, 62008, 61737, 63052, 63478, 62799, 59246, 64765, 64066, 63862, 65384, 67449, 66552, 57741, 45618, 44412, 667, 69718, 75519, 76819, 72971, 79319, 78145, 80615, 84280, 80984, 86598, 85903, 84334, 80867, 87993, 92361, 88465, 87738, 80364, 94380, 94446, 96785, 93694, 76847, 99655, 98675, 97001, 72112};
        final long l = System.currentTimeMillis();
        System.out.println(verifyPostorder(arr));
        final long l2 = System.currentTimeMillis();
        System.out.println(l2-l);
    }

    public static boolean verifyPostorder(int[] postorder) {
        if(postorder == null) return false;
        return verifyPostorder(postorder, 0, postorder.length-1);
    }

    public static boolean verifyPostorder(int[] postorder, int start, int end) {

        if(start >= end) return true;
        int root = postorder[end];
        int i=start;
        for(; i<=end-1; i++){
            if(postorder[i]> root){
                break;
            }
        }

        int j = i;
        for(; j<=end-1; j++){
            if(postorder[j]< root){
                return false;
            }
        }
        System.out.println("start=" +start +",end="+end+",左边="+"0到"+(i-1)+",右边="+ i+"到"+(end-1));
        return verifyPostorder(postorder,start, i-1) && verifyPostorder(postorder,i,end-1);
    }
}
