package doubleLinkTest;

public class DoubleLinkTest {
    public static void main(String[] args) {
		DoubleLinkTest.DoubleLink kc = new DoubleLinkTest().new DoubleLink(500);
		LinkNode k = kc.getFirst();

		System.out.println(kc.getFirst().getId());
		System.out.println(kc.getLast().getLeft().getLeft().getId());

	}

	//双向链表节点
	class LinkNode {
		private int id;
		private LinkNode left;
		private LinkNode right;

		LinkNode(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public LinkNode getLeft() {
			return left;
		}

		public void setLeft(LinkNode left) {
			this.left = left;
		}

		public LinkNode getRight() {
			return right;
		}

		public void setRight(LinkNode right) {
			this.right = right;
		}
	}

	//双向链表
	class DoubleLink {
		private int size;
		private int count = 0;
		private LinkNode first,last;
		//用构造函数初始化链表
		DoubleLink(int size) {
			this.size = size;
			for(int i = 0; i < size; i++) {
				addNode();
			}
		}

		public void addNode() {
			LinkNode node = new LinkNode(count);
			if(count <= 0) {
				first = node;
				last = node;
				node.setLeft(node);
				node.setRight(node);
			} else {
				last.setRight(node);//最后一个节点右侧指向当前生成的新节点。
				node.setLeft(last);//新节点的左侧指向上一个，也就是最后的节点。
				node.setRight(first);//新节点的右侧节点指向链表的开始节点。
				first.setLeft(node);//开始节点的左侧指向当前的节点。形成循环
				last = node;
			}
			count++;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public LinkNode getFirst() {
			return first;
		}

		public void setFirst(LinkNode first) {
			this.first = first;
		}

		public LinkNode getLast() {
			return last;
		}

		public void setLast(LinkNode last) {
			this.last = last;
		}

	}
}
