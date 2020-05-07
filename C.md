#include <stdio.h>
#include <stdlib.h>
#define MAX_QUEUE_SIZE 100

typedef int TElment;
TElment data[MAX_QUEUE_SIZE];
int front;
int rear;

//노드 구조체와 기본 연산
typedef struct BinTrNode
{
	TElment data;
	struct BinTrNode* left;
	struct BinTrNode* right;
}TNode;
TNode* root;

void init_tree() { root = NULL; }
int is_empty_tree() { return root == NULL; }
TNode* get_root() { return root; }

void init_queue() { front = rear = 0; }
int is_empty() { return front == rear; }
int is_full() { return front == (rear + 1) % MAX_QUEUE_SIZE; }
int size() { return (rear - front + MAX_QUEUE_SIZE) % MAX_QUEUE_SIZE; }

//트리
TNode* create_tree(TElment val, TNode* l, TNode* r)
{
	TNode* n = (TNode*) malloc(sizeof(TNode));
	n->data = val;
	n->left = l;
	n->right = r;

	return n;
}

//전위 순회
void preorder(TNode* n)
{
	if (n != NULL)
	{
		printf("[%c] ", n->data);
		preorder(n->left);
		preorder(n->right);
	}
}

//중위 순회
void inorder(TNode* n)
{
	if (n != NULL)
	{
		inorder(n->left);
		printf("[%c] ", n->data);
		inorder(n->right);
	}
}

//후위 순회
void postorder(TNode* n)
{
	if (n != NULL)
	{
		postorder(n->left);
		postorder(n->right);
		printf("[%c] ", n->data);
	}
}

//오류
void error(const char* str)
{
	printf("%s\n", str);
	exit(1);
}

//포화 에러
void enqueue(TElment val)
{
	if (is_full())
		error("  큐 포화 에러");

	rear = (rear + 1) % MAX_QUEUE_SIZE;
	data[rear] = val;
}

//공백 에러1
TElment dequeue()
{
	if (is_empty())
		error("  큐 공백 에러");

	front = (front + 1) % MAX_QUEUE_SIZE;

	return data[front];
}

//공백 에러2
TElment peek()
{
	if (is_empty())
		error("  큐 공백 에러");

	return data[(front + 1) % MAX_QUEUE_SIZE];
}

//레벨 순회
void levelorder(TNode* root)
{
	TNode* n;

	if (root == NULL) return;

	init_queue();
	enqueue(root);//******** 'root' ******(지역변수) TNode* root *******"TNode*" 형식의 인수가 "TElment" 형식의 매개 변수의 호환되지 않습니다.
	while (!is_empty())
	{
		n = dequeue();//******************* '=' *******************"TElment" 형식의 값을 "TNode*" 형식의 엔터티에 할당할 수 없습니다.
		if (n != NULL)
		{
			printf("[%c] ", n->data);
			enqueue(n->left);//***** 'n' ****(지역변수) TNode* n ****"BinTrNode" 형식의 인수가 "TElment" 형식의 매개 변수와 호환되지 않습니다.
			enqueue(n->right);//***** 'n' ****(지역변수) TNode* n ****"BinTrNode" 형식의 인수가 "TElment" 형식의 매개 변수와 호환되지 않습니다.
		}
	}
}

//노드 갯수 출력
int count_node(TNode* n)
{
	if (n == NULL)
		return 1 + count_node(n->left) + count_node(n->right);
}

//단말 노드 갯수 출력
int count_leaf(TNode* n)
{
	if (n == NULL) return 0;
	if (n->left == NULL && n->right == NULL) return 1;
	else return count_leaf(n->left) + count_leaf(n->right);
}

//높이 출력
int calc_height(TNode* n)
{
	int hLeft, hRight;

	if (n == NULL) return 0;

	hLeft = calc_height(n->left);
	hRight = calc_height(n->right);

	return (hLeft > hRight) ? hLeft + 1 : hRight + 1;
}

//탐색
TNode* search(TNode* n, int key)
{
	if (n == NULL) return NULL;
	else if (key == n->data) return n;
	else if (key < n->data) return search(n->left, key);
	else return search(n->right, key);
}

void search_BST(int key)
{
	TNode* n = search(root, key);

	if (n != NULL)
		printf("[탐색 연산] : 성공 [%d] = 0x%x\n", n->data, n);
	else
		printf("[탐색 연산] : 실패: NO %d!\n", key);
}

//삽입
int insert(TNode* r, TNode* n)
{
	if (n->data == r->data) return 0;
	else if (n->data < r->data)
	{
		if (r->left == NULL) r->left = n;
		else insert(r->left, n);
	}
	else
	{
		if (r->right == NULL) r->right = n;
		else insert(r->right, n);
	}

	return 1;
}

void insert_BST(int key)
{
	TNode* n = create_tree(key, NULL, NULL);
	if (is_empty_tree())
		root = n;
	else if (insert(root, n) == 0)
		free(n);
}

//삭제
void Tdelete(TNode* parent, TNode* node)
{
	TNode* child, * succ, * succp;

	// 1
	if (node->left == NULL && node->right == NULL)
	{
		if (parent == NULL) root = NULL;
		else
		{
			if (parent->left == node)
				parent->left = NULL;
			else parent->right = NULL;
		}
	}

	//2
	else if (node->left == NULL || node->right == NULL)
	{
		child = (node->left != NULL) ? node->left : node->right;
		if (node == root) root = child;
		else
		{
			if (parent->left == node)
				parent->left = child;
			else parent->right = child;
		}
	}

	//3
	else
	{
		succp = node;
		succ = node->right;

		while (succ->left != NULL)
		{
			succp = succ;
			succ = succ->left;
		}

		if (succp->left == succ)
			succp->left = succ->right;
		else succp->right = succ->right;

		node->data = succ->data;
		node = succ;
	}
	free(node);
}

void delete_BST(int key)
{
	TNode* parent = NULL;
	TNode* node = root;

	if (node == NULL) return;
	while (node != NULL && node->data != key)
	{
		parent = node;
		node = (key < node->data) ? node->left : node->right;
	}

	if (node == NULL)
		printf(" Error: key is not in the free!\n");
	else Tdelete(parent, node);
}
