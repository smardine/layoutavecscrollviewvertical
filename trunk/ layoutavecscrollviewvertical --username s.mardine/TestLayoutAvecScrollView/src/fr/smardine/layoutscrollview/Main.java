package fr.smardine.layoutscrollview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;

public class Main extends Activity implements OnClickListener {
	ImageView ImageHaut,ImageDeux,ImageTrois,ImageBas;
	boolean dejacliqu�=false,dejacliqu�Bas=false,dejacliqu�Deux=false,dejacliqu�Trois=false;
	ArrayList<produit> produitsCat1 = new ArrayList<produit>(); 
	ArrayList<produit> produitsCat2 = new ArrayList<produit>();
	ArrayList<produit> produitsCat3 = new ArrayList<produit>();
	ArrayList<produit> produitsCat4 = new ArrayList<produit>();
	ListView ProduitListView1,ProduitListView2,ProduitListView3,ProduitListView4;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.copyofmain);
        ProduitListView1 = (ListView)this.findViewById(R.id.produitListView01);
    	ProduitListView2 = (ListView) this.findViewById(R.id.produitListView02);
    	ProduitListView3 = (ListView)this.findViewById(R.id.produitListView03);
    	ProduitListView4 = (ListView) this.findViewById(R.id.produitListView04); 
    	    	
    	ImageHaut = (ImageView)this.findViewById(R.id.ImageView01);
        ImageDeux = (ImageView) this.findViewById (R.id.ImageView02);
        ImageTrois = (ImageView) findViewById (R.id.ImageView03);
        ImageBas = (ImageView)this.findViewById(R.id.ImageView04);
         
        ImageHaut.setOnClickListener(this);
        ImageDeux.setOnClickListener(this);
        ImageTrois.setOnClickListener(this);
        ImageBas.setOnClickListener(this);
        
    }
    
public void onClick(View v) {
		
		
		if (v == ImageHaut) {//si le bouton cliqu� est le "boutonClient"
			
			if (!dejacliqu�){
				produitsCat1.add(new produit("Sous cat1 ESSAI Faust","05/04/1993"));
				produitsCat1.add(new produit("Sous cat1 CARTE Lucille","20/03/1961"));
				produitsCat1.add(new produit("Sous cat1 TREIZE Hugo","01/10/2007"));
		        dejacliqu�=true;
			}else{
				produitsCat1.removeAll(produitsCat1);
				dejacliqu�=false;
			}
			
			AfficheLeContenu (produitsCat1,ProduitListView1);
		}
		if (v== ImageDeux){
			if (!dejacliqu�Deux){
				produitsCat2.add(new produit("Sous cat2 ESSAI Faust","05/04/1993"));
				produitsCat2.add(new produit("Sous cat2 CARTE Lucille","20/03/1961"));
				produitsCat2.add(new produit("Sous cat2 TREIZE Hugo","01/10/2007"));
				dejacliqu�Deux=true;
			}else{
				produitsCat2.removeAll(produitsCat2);
				dejacliqu�Deux=false;
			}
			AfficheLeContenu (produitsCat2,ProduitListView2);
		}
		if (v== ImageTrois){
			if (!dejacliqu�Trois){
				produitsCat3.add(new produit("Sous cat3 ESSAI Faust","05/04/1993"));
				produitsCat3.add(new produit("Sous cat3 CARTE Lucille","20/03/1961"));
				produitsCat3.add(new produit("Sous cat3 TREIZE Hugo","01/10/2007"));
				dejacliqu�Trois=true;
			}else{
				produitsCat3.removeAll(produitsCat3);
				dejacliqu�Trois=false;
			}
			AfficheLeContenu (produitsCat3,ProduitListView3);
		}
		if (v== ImageBas){
			if (!dejacliqu�Bas){
				produitsCat4.add(new produit("Sous cat4 ESSAI Faust","05/04/1993"));
				produitsCat4.add(new produit("Sous cat4 CARTE Lucille","20/03/1961"));
				produitsCat4.add(new produit("Sous cat4 TREIZE Hugo","01/10/2007"));
				dejacliqu�Bas=true;
			}else{
				produitsCat4.removeAll(produitsCat4);
				dejacliqu�Bas=false;
			}
			AfficheLeContenu (produitsCat4,ProduitListView4);
		}
			 	
		      
		        
		}

private void AfficheLeContenu(ArrayList<produit> produits,
		ListView produitListView) {
	//ListView produitlistview = (ListView)this.findViewById(R.id.produitListView1);
    
    //animation d'affichage cascade du haut vers le bas
    AnimationSet set = new AnimationSet(true);
    Animation animation = new AlphaAnimation(0.0f, 1.0f);
    animation.setDuration(100);
    set.addAnimation(animation);
    animation = new TranslateAnimation(
        Animation.RELATIVE_TO_SELF, 0.0f,Animation.RELATIVE_TO_SELF, 0.0f,
        Animation.RELATIVE_TO_SELF, -1.0f,Animation.RELATIVE_TO_SELF, 0.0f
    );
    animation.setDuration(100);
    set.addAnimation(animation);
    LayoutAnimationController controller = new LayoutAnimationController(set, 0.5f);
    produitListView.setLayoutAnimation(controller);
    
    //param�trer l'adapteur correspondant
    produitListAdapter adpt = new produitListAdapter(this, produits);
    //param�ter l'adapter sur la listview
    produitListView.setAdapter(adpt);
	
}
			
		
}
