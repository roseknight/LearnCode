package com.junma.leetcode.hashtable;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;

public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
                
        if ((S==null)||(S.length()==0)||(L==null)||(L.length==0)) {
            return result;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String strTemp : L) {
            map.put(strTemp, -1);
        }
        
        int wordLen = L[0].length();
        int l = 0;
        int count = 0;
        
        for(int j=0; j<=S.length()-wordLen; j+=wordLen) {
            String strWord = S.substring(j, j+wordLen);
            if (map.containsKey(strWord)) {
                // The word is in L
                int pos = map.get(strWord);
                if (pos<l) {
                    // No found before
                    map.put(strWord, j);
                    count++;
                    if (count==L.length) {
                      // Find all words in L
                      result.add(l);
                    } 
                } else {
                    // Found before
                    String strWord2;
                    while(l<pos+wordLen) {
                        strWord2 = S.substring(l, l+wordLen);
                        map.put(strWord2, -1);
                        count--;
                        l = l+wordLen;
                    };
                    map.put(strWord, j);
                    count++;
                }
            } else {
                // The word is not in L. reset
                l = j+wordLen;
                count = 0;
            }
        }
        
        return result;
    }
    
	@Test
	public void test() {
		String S = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		List<Integer> result = findSubstring(S, L);
		List<Integer> result1 = new ArrayList<Integer>();
		result1.add(0);
		result1.add(9);
		assertEquals(result1, result);
	}

    
	@Test
	public void test2() {
		String S = "a1a2a3a2a1";
		String[] L = {"a1", "a2", "a3"};
		List<Integer> result = findSubstring(S, L);
		List<Integer> result1 = new ArrayList<Integer>();
		result1.add(0);
		result1.add(4);
		assertEquals(result1, result);
	}
	
	@Test
	public void test3() {
		String S = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
		String[] L = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
		List<Integer> result = findSubstring(S, L);
		for(int i:result) {
			System.out.println(i);
		}	
		
		System.out.println(Integer.parseInt("64.40625"));
	}
	

}
