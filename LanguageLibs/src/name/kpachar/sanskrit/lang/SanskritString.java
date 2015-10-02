package name.kpachar.sanskrit.lang;

import java.util.ArrayList;
import java.util.List;

public class SanskritString {
	private String originalString;
	private int[] codepoints;
	//TODO: Use Guava's interner and get rid of this constructor to avoid duplicate SanskritString objects with the same content
	public SanskritString(String s){
		if(s==null){
			codepoints=new int[0];
		}
		originalString = s;
		codepoints=canonicalize(s.codePoints().toArray());
	}

	public String toCanonicalString(){
		return new String(codepoints, 0, codepoints.length);
	}
	public String getOriginalString(){
		return originalString;
	}
	public int[] getCodepoints(){
		return codepoints;
	}
	public static String toString(int[] codepoints){
		List<Integer> out = new ArrayList<Integer>();
		for(int i=0; i<codepoints.length; i++){
			int n=0;
			if(i<codepoints.length-1){
				n=codepoints[i+1];
			}
			if(codepoints[i]==0x94d){
				int modifier = getModifier(n);
				if(modifier==-1){
					i++;
					continue;
				}
				if(modifier!=0){
					out.add(modifier);
					i++;
					continue;
				}
			}
			out.add(codepoints[i]);
		}
		int[] intArray = new int[out.size()];
		for(int i=0; i<out.size(); i++){
			intArray[i]=out.get(i);
		}
		return new String(intArray, 0, intArray.length);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if(obj==null){
			return false;
		}
		if(obj instanceof SanskritString){
			SanskritString other = (SanskritString)obj;
			if(other.originalString==null && this.originalString==null){
				return true;
			}
			if(other.originalString==null && this.originalString!=null){
				return false;
			}
			if(other.originalString!=null){
				return other.originalString.equals(this.originalString);
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return SanskritString.toString(codepoints);
	}
	 private static int[] canonicalize(int[] codepoints){
		 List<Integer> out = new ArrayList<Integer>();
		 
		 for(int idx=0; idx<codepoints.length; idx++){
			 int n=0;
			 if(idx<codepoints.length-1){
				 n=codepoints[idx+1];
			 }
			 int i=codepoints[idx];
			 switch(i){
			 case 0x900:
			 case 0x901:
			 case 0x902:
				 int a = getAnusvara(n);
				 if(a>0){
					 if(a!=0x902){
						 out.add(a);
						 out.add(0x94d);
					 }else{
						 out.add(0x902);
					 }
				 }
				 break;
			 case 0x903:
				 out.add(i);
				 break;
			 case 0x904:
				 out.add(0x90f);
				 break;
			 case 0x905:
			 case 0x906:
			 case 0x907:
			 case 0x908:
			 case 0x909:
			 case 0x90a:
			 case 0x90b:
			 case 0x90c:
				 out.add(i);
				 break;
			 case 0x90d:
			 case 0x90e:
			 case 0x90f:
				 out.add(0x90f);
				 break;
			 case 0x910:
				 out.add(i);
			 case 0x911:
				 out.add(0x906);
				 break;
			 case 0x912:
			 case 0x913:
				 out.add(0x913);
				 break;
			 case 0x914:
				 out.add(0x914);
				 break;
			 case 0x915:
			 case 0x916:
			 case 0x917:
			 case 0x918:
			 case 0x919:
			 case 0x91a:
			 case 0x91b:
			 case 0x91c:
			 case 0x91d:
			 case 0x91e:
			 case 0x91f:
			 case 0x920:
			 case 0x921:
			 case 0x922:
			 case 0x923:
			 case 0x924:
			 case 0x925:
			 case 0x926:
			 case 0x927:
			 case 0x928:
				 out.add(i);
				 out.add(0x94d);
				 if(!isModifier(n)){
					 out.add(0x905);
				 }
				 break;
			 case 0x929:
				 out.add(0x928);
				 out.add(0x94d);
				 if(!isModifier(n)){
					 out.add(0x905);
				 }
				 break;
			 case 0x92a:
			 case 0x92b:
			 case 0x92c:
			 case 0x92d:
			 case 0x92e:
			 case 0x92f:
			 case 0x930:
				 out.add(i);
				 out.add(0x94d);
				 if(!isModifier(n)){
					 out.add(0x905);
				 }
				 break;
			 case 0x931:
				 out.add(0x930);
				 out.add(0x94d);
				 if(!isModifier(n)){
					 out.add(0x905);
				 }
				 break;
			 case 0x932:
			 case 0x933:
			 case 0x934:
				 out.add(0x932);
				 out.add(0x94d);
				 if(!isModifier(n)){
					 out.add(0x905);
				 }
				 break;
			 case 0x935:
			 case 0x936:
			 case 0x937:
			 case 0x938:
			 case 0x939:
				 out.add(i);
				 out.add(0x94d);
				 if(!isModifier(n)){
					 out.add(0x905);
				 }
				 break;
			 case 0x93a:
				 break;
			 case 0x93b:
				 out.add(0x906);
			 case 0x93c:
				 break;
			 case 0x93d:
				 break;
			 case 0x93e:
				 out.add(0x906);
				 break;
			 case 0x93f:
				 out.add(0x907);
				 break;
			 case 0x940:
				 out.add(0x908);
				 break;
			 case 0x941:
				 out.add(0x909);
				 break;
			 case 0x942:
				 out.add(0x90a);
				 break;
			 case 0x943:
				 out.add(0x90b);
				 break;
			 case 0x944:
				 out.add(0x960);
				 break;
			 case 0x945:
				 out.add(0x902);
				 break;
			 case 0x946:
			 case 0x947:
				 out.add(0x90f);
				 break;
			 case 0x948:
				 out.add(0x910);
				 break;
			 case 0x949:
				 out.add(0x906);
				 break;
			 case 0x94a:
			 case 0x94b:
				 out.add(0x913);
				 break;
			 case 0x94c:
				 out.add(0x914);
				 break;
			 case 0x94d:
				 break;
			 case 0x94f:
				 out.add(0x914);
				 break;
			 case 0x950:
				 out.add(0x950);
				 break;
			 case 0x951:
			 case 0x952:
			 case 0x953:
			 case 0x954:
			 case 0x955:
			 case 0x956:
			 case 0x957:
			 case 0x958:
			 case 0x959:
			 case 0x95a:
			 case 0x95b:
			 case 0x95c:
			 case 0x95d:
			 case 0x95e:
			 case 0x95f:
			 case 0x960:
				 out.add(i);
				 break;
			 case 0x961:
				 out.add(i);
				 break;
			 case 0x962:
				 out.add(0x960);
				 break;
			 case 0x963:
				 out.add(0x961);
				 break;
			 case 0x964:
			 case 0x965:
			 case 0x966:
			 case 0x967:
			 case 0x968:
			 case 0x969:
			 case 0x96a:
			 case 0x96b:
			 case 0x96c:
			 case 0x96d:
			 case 0x96e:
			 case 0x96f:
				 out.add(i);
				 break;
			 case 0x970:
			 case 0x971:
			 case 0x972:
			 case 0x973:
			 case 0x974:
			 case 0x975:
			 case 0x976:
			 case 0x977:
			 case 0x978:
			 case 0x979:
			 case 0x97a:
			 case 0x97b:
			 case 0x97c:
			 case 0x97d:
			 case 0x97e:
			 case 0x97f:
				 break;
			 default:
				 out.add(i);
			 }
		 }
		 
		 int[] outArray=new int[out.size()];
		 for(int idx=0; idx<out.size(); idx++){
			 outArray[idx]=out.get(idx);
		 }
		 return outArray;
	 }
	 private static int getAnusvara(int next){
		 if(next>=0x915 && next<=0x918)return 0x919;
		 if(next>=0x91a && next<=0x91d)return 0x91e;
		 if(next>=0x91f && next<=0x922)return 0x923;
		 if(next>=0x924 && next<=0x927)return 0x928;
		 if(next>=0x92a && next<=0x92d)return 0x92e;
		 if(next==0x919 || next==0x91e || next==0x923 || next==0x929 || next==0x92e){
			 return 0;
		 }
		 return 0x902;
	 }
	 private static boolean isModifier(int i){
		 if((i>=0x93e && i<=0x94f) || (i>=0x962 && i<=0x963)){
			 return true;
		 }
		 return false;
	 }
	 private static int getModifier(int swara){
		 switch(swara){
		 case 0x905:
			 return -1;
		 case 0x906:
			 return 0x93e;
		 case 0x907:
			 return 0x93f;
		 case 0x908:
			 return 0x940;
		 case 0x909:
			 return 0x941;
		 case 0x90a:
			 return 0x942;
		 case 0x90b:
			 return 0x943;
		 case 0x90c:
			 return 0x962;
		 case 0x90f:
			 return 0x947;
		 case 0x910:
			 return 0x948;
		 case 0x913:
			 return 0x94b;
		 case 0x914:
			 return 0x94c;
		 case 0x960:
			 return 0x944;
		 case 0x961:
			 return 0x963;
		 default:
				 return 0;
		 }
	 }
}
