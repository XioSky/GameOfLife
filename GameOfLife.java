class GameOfLife extends Program{
	boolean monde[][] = new boolean[8][8];
	
	void algorithm(){
		monde[1][1] = true;
		monde[2][1] = true;
		monde[3][1] = true;
		monde = nextGen(monde);
		print(monde);
	}
	
	boolean[][] nextGen(boolean[][] m){
		boolean[][] next = monde;
		//print("next  ");
		//print(next);

		for(int i = 1 ; i < length(m, 1)-1 ; i++){
			for(int j = 1 ; j < length(m, 2)-1 ; j++){
				if(m[i][j]){
					if(voisins(monde, i, j) < 2){
						//print("** : " + voisins(monde, i, j));
						next[i][j] = false;
					}
					
				}
			}
		}
		return next;
	}
	
	int voisins(boolean[][] m, int i, int j){
		int tmp = 0;

		if(m[i][j-1]){ tmp++; }
		if(m[i][j+1]){ tmp++; }
		if(m[i-1][j]){ tmp++; }
		if(m[i+1][j]){ tmp++; }
		if(m[i-1][j+1]){ tmp++; }		
		if(m[i+1][j-1]){ tmp++; }
		if(m[i-1][j-1]){ tmp++; }
		if(m[i+1][j+1]){ tmp++; }
		
		return tmp;
	}
	
	void print(boolean[][] m){
		for(int i = 0 ; i < length(m, 1) ; i++){
			for(int j = 0 ; j < length(m, 2) ; j++){
				if(!m[i][j]){
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
