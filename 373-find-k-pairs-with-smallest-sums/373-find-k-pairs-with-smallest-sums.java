class Solution {
	class triple
	{
		int x,y;
		long sum;
		triple()
		{

		}
		triple(int x,int y,int sum)
		{
			this.x=x;
			this.y=y;
			this.sum=sum;
		}

	}
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> list=new ArrayList<>();
		PriorityQueue<triple> pq=new PriorityQueue<>(new Comparator<triple>(){
			public int compare(triple t1,triple t2)
			{
				return (int)(t1.sum-t2.sum);
			}
		});
		int n1=nums1.length,n2=nums2.length;
		for(int i=0;i<n2;i++)
		{
			pq.offer(new triple(1,i+1,nums1[0]+nums2[i]));
		}
		while(k>0 && !pq.isEmpty())
		{
			// for(triple t:pq)
			// {
			//       System.out.println(t.x+","+t.y+","+t.sum);
			// }
			triple temp=pq.poll();
			List<Integer> lst=new ArrayList<>();
			lst.add(nums1[temp.x-1]);
			lst.add(nums2[temp.y-1]);
			  // System.out.println("Priority Queue ->"+temp.x+","+temp.y);
			  // System.out.println("I am here");
			list.add(lst);
			k--;
			if(temp.x<n1)
				pq.offer(new triple(temp.x+1,temp.y,nums1[temp.x]+nums2[temp.y-1]));
			 // System.out.println("I am here");
		}
		return list;

	}
}