// LeetCode 990. Satisfiability of Equality Equations
package satisfiabilityofequalityequations;

import basicdatastructure.UF;

public class Solution {
    public boolean equationsPossible(String[] equations) {
        // 26 English letters
        UF uf = new UF(26);

        // make equaled letters as connected components
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }

        // check if the unequal relationship breaks the connectivity of equal realtionship
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);

                // if the equality relation holds, there is a logic conflict
                if (uf.connected(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}
