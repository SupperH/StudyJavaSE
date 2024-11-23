package 堆;

/*大顶堆
* 理解为树
* 每个父节点比子节点大即可
* 给定一个数组然后转换成堆
*   1.找到最后一个非叶子节点
*   2.从后向前，对每个节点执行下潜
* */
public class MaxHeap {

    public int[] array;
    public int size;

    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }

    //初始化的时候，建堆
    public MaxHeap(int[] array) {
        this.array = array;
        this.size=array.length;
        heapify();
    }

    //获取堆顶元素 不删除 初始化的时候堆已经完成了建立，排序，这里直接取就行了
    public int peek(){
        //直接返回第一个元素就是堆顶元素
        return array[0];
    }
    //删除堆顶元素
    public int poll(){
        int top =array[0];

        //删除的逻辑是，把顶部元素和最后一个底部元素交换，然后让size减少一位
        //这样循环的时候就不会再拿到删除后的最后一个元素，也就是达到了删除效果
        swap(0,size-1);
        size--;

        //底部元素交换到上面后，为了满足堆的特性，需要堆元素进行下潜，下潜
        //内容就是第一个元素
        down(0);
        return top;
    }

    //删除指定索引处的元素
    public int poll(int index){
        //跟删除堆顶元素的逻辑是一样的
        int deleted = array[index];

        swap(index,size-1);
        size--;
        down(index);

        return deleted;
    }

    //替换堆顶元素
    public void replace(int replaced){
        array[0] = replaced;
        down(0);

    }

    //堆的尾部添加元素
    public boolean offer(int offered){
        if(size == array.length){
            return false;
        }
        //让新元素上浮
        up(offered);
        size++;
        return true;
    }

    //上浮，从底部往上走，当元素大于自身时或者到顶时，停止上浮
    private void up(int offered){
        //最底部指针
        int child=size;
        //当子元素指针大于0，说明没到堆顶 那么就循环上浮
        while(child>0){
            //TODO:计算出子元素对应的父元素下标 固定公式
            int parent = (child-1)/2;
            //如果要上浮的元素大于父元素，
            // 那么parent的元素需要向下，所以parent应该赋值给child，这样就达到了父元素向下走的要求
            if(offered > array[parent]){
                /*
                * 这一步看着是让两个节点的值一样有点怪
                * 但是每次循环后child都会上浮到parent位置然后继续比较
                * 而且child位置最后是要等于offered的
                * 所以这一步单纯就是让父节点下潜到child位置
                * 然后再每一次循环最后child上浮到parent节点还会继续比较
                * */
                array[child] = array[parent];

            //否则推出循环，没有比下去的必要了
            }else{
                break;
            }
            //每一次循环最后，让child下标等于parent下标，然后才可以让parent继续计算
            child = parent;

        }
        //最后当比较完以后，child就是最后一次进行比较的位置
        // 那么直接将当前child位置的值变成插入的值即可
        array[child]=offered;

    }



    //建堆
    private void heapify(){
        //找到最后的非叶子节点 size/2 -1
        for(int i= size/2-1;i>=0;i--){
            down(i);
        }
    }

    //下潜方法，索引处的元素下潜，与两个孩子较大的交换，一直到没用孩子比他大
    public void down(int parent){
        //找到两个孩子的索引
        //TODO：这个计算左右子节点是固定的写法 死记！
        int left=parent*2+1;
        int right = left+1;

        //定义最大的索引值
        int max = parent;
        //判断哪边大，就让最大值等于谁
        if(left < size &&array[left] > array[max]){
            max = left;
        }
        if(right < size &&array[right] > array[max]){
            max = right;
        }

        //当max不等于parent说明确实是找到了更大的子节点
        if(max!=parent){
            swap(max,parent);
            down(max);//递归调用，因为可能会有多次进行交换的情况
        }
    }


    //交换两个索引处的元素
    public void swap(int i,int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
