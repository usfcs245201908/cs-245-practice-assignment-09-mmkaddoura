public class BinaryHeap{

	int size;
	int[]data;

	public BinaryHeap(){
		data=new int[10];
		size=0;
	}



	public void add(int item){
		if(size==data.length)
			growArray();
		data[size++]=item;
		int child = size-1;
		int parent = (child-1)/2;
		while((parent>=0)&&(data[parent]>data[child])){
			swap(data,parent,child);
			child = parent;
			parent = (child-1)/2;
		}
	}

	protected void swap(int[]a,int x,int y){
		int temp = a[x];
		a[x]=a[y];
		a[y]=temp;
	}

	protected void growArray(){
		int[] a2 = (int[]) new int[data.length*2];
		for(int i=0; i < data.length; i++) {
			a2[i]=data[i];
		}
		data = a2;
	}

	public int remove(){
		int removed=data[0];
		data[0]=data[--size];
		siftdown(0);
		return removed;
	}

	protected void siftdown(int pos){
		int child=2*pos+1;
		if(child>=size)
			return;
		if((data[child]>data[child+1])&&(child+1<size))
			child=child+1;
		if(data[pos]>data[child]){
			swap(data,pos,child);
			siftdown(child);
		}
	}
}