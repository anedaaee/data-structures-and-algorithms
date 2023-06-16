import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HuffmanCode {
    private String text;
    public priorityQueue queue;
    public ArrayList<Node> leafs;
    private ArrayList<Character> characters;
    private Node root;
    public Map<Character, String> encodingMap ;
    HuffmanCode(String text){
        this.queue = new priorityQueue();
        this.leafs = new ArrayList<>();
        this.text=text;
        this.encodingMap =  new HashMap<>();
        this.control();
    }
    private void getCharacter(){
        this.characters = new ArrayList<>();
        this.characters.add(this.text.charAt(0));
        char ch;
        boolean flag;
        for(int i = 1 ; i < this.text.length() ;i++){
            ch = this.text.charAt(i);
            flag = false;
            for(int j = 0 ; j < this.characters.size() ; j++){
                if(ch == this.characters.get(j)){
                    flag = true;
                }
            }
            if(flag == false){
                this.characters.add(ch);
            }
        }
    };
    private void getValueCharacter(){
        int n;
        for (Character ch : this.characters){
            n=0 ;
            for(int i = 0 ; i < this.text.length() ; i++){
                if(ch == this.text.charAt(i)){
                    n++;
                }
            }
            Node node = new Node(n,ch,true);
            this.queue.add(node);
            this.leafs.add(node);
        }
    }
    public void generateCode(){
        Node node1,node2,parent = new Node();
        while(!this.queue.isEmpty()){
            if(this.queue.len()>1){
                node1 = this.queue.get();
                node2 = this.queue.get();
                if(node1.value <= node2.value){
                    parent = new Node(node1.value+node2.value,'-',false);
                    parent.leftChild = node1;
                    parent.rightChild = node2;
                    this.queue.add(parent);
                }else{
                    parent = new Node(node1.value+node2.value,'-',false);
                    parent.rightChild = node1;
                    parent.leftChild = node2;
                    this.queue.add(parent);
                }

            }else if(this.queue.len() == 1) {
                parent = this.queue.get();
            }
        }
        this.root = parent;
    }
    private void buildCode (Node node ,String code){
        if (node == null) {
            return ;
        }
        if (node.leftChild == null && node.rightChild == null) {
            this.encodingMap.put(node.character, code);
        }
        this.buildCode(node.leftChild, code + "0");
        this.buildCode(node.rightChild, code + "1");
    }
    public String encode() {
        StringBuilder encodedText = new StringBuilder();
        for (char c : this.text.toCharArray()) {
            encodedText.append(encodingMap.get(c));
        }
        return encodedText.toString();
    }
    private void control(){
        this.getCharacter();
        this.getValueCharacter();
        this.generateCode();
        this.buildCode(this.root,"");
        String encode = this.encode();
        for(int i = 0  ; i < this.encodingMap.size() ;i++){
            System.out.println(this.characters.get(i) +" : "+ this.encodingMap.get(this.characters.get(i)));
        }
        System.out.println(encode);
    }
}
