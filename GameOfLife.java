import extensions.Image;
import extensions.RGBColor;

class GameOfLife extends Program {
    boolean monde[][] = new boolean[40][40];
    

    void algorithm() {
	Image img = newImage(600,600);
	setGrid(img, 40, 40);
	show(img);
	monde[4][1] = true;
	monde[4][2] = true;
	monde[4][3] = true;
	monde[3][3] = true;
	monde[2][2] = true;
	while(true){
	    monde = nextGen(monde);
	    delay(100);
	    setImage(img, monde);
	}
    }

    void setImage(Image img, boolean[][] tab){
	for(int i = 1 ; i < length(tab, 1) -1; i++){
	    for(int j = 1 ; j < length(tab, 2) -1; j++){
		if(tab[i][j]){
		    set(img, i, j, RGBColor.BLACK);
		}
		else{
		    set(img, i, j, RGBColor.WHITE);
		}
	    }
	}
    }
    
    boolean[][] nextGen(boolean[][] m) {
	boolean[][] next = new boolean[length(monde)][length(monde)];
	
	
	for (int i = 1; i < length(m, 1) - 1; i++) {
	    for (int j = 1; j < length(m, 2) - 1; j++) {
		if(voisins(monde, i, j) == 3 ){
		    next[i][j] = true;
		}
		if(voisins(monde, i, j) == 2 && monde[i][j]){
		    next[i][j] = true;
		}
	    }
	    
	}
	return next;
    }
    
    int voisins(boolean[][] m, int i, int j) {
	int tmp = 0;
	
	if (m[i][j - 1]) {
	    tmp++;
	}
	if (m[i][j + 1]) {
	    tmp++;
	}
	if (m[i - 1][j]) {
	    tmp++;
	}
	if (m[i + 1][j]) {
	    tmp++;
	}
	if (m[i - 1][j + 1]) {
	    tmp++;
	}
	if (m[i + 1][j - 1]) {
	    tmp++;
	}
	if (m[i - 1][j - 1]) {
	    tmp++;
	}
	if (m[i + 1][j + 1]) {
	    tmp++;
	}
	
	return tmp;
    }
    
    void print(boolean[][] m) {
	for (int i = 0; i < length(m, 1); i++) {
	    for (int j = 0; j < length(m, 2); j++) {
		if (!m[i][j]) {
		    print(".");
		} else {
		    print("o");
		}
	    }
	    println();
	}
    }
    
    //
    
    //
    
    //
	public static void main(String[] args){
		Program.main(args);	
	}
	}  
}
