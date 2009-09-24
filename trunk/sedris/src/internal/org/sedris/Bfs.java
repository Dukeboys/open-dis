// SRM SDK Release 4.1.1 - June 23, 2007

// - SRM spec. 4.1

/*
 *                             NOTICE
 * 
 * This software is provided openly and freely for use in representing and
 * interchanging environmental data & databases.
 * 
 * This software was developed for use by the United States Government with
 * unlimited rights.  The software was developed under contract
 * DASG60-02-D-0006 TO-193 by Science Applications International Corporation.
 * The software is unclassified and is deemed as Distribution A, approved
 * for Public Release.
 * 
 * Use by others is permitted only upon the ACCEPTANCE OF THE TERMS AND
 * CONDITIONS, AS STIPULATED UNDER THE FOLLOWING PROVISIONS:
 * 
 *    1. Recipient may make unlimited copies of this software and give
 *       copies to other persons or entities as long as the copies contain
 *       this NOTICE, and as long as the same copyright notices that
 *       appear on, or in, this software remain.
 * 
 *    2. Trademarks. All trademarks belong to their respective trademark
 *       holders.  Third-Party applications/software/information are
 *       copyrighted by their respective owners.
 * 
 *    3. Recipient agrees to forfeit all intellectual property and
 *       ownership rights for any version created from the modification
 *       or adaptation of this software, including versions created from
 *       the translation and/or reverse engineering of the software design.
 * 
 *    4. Transfer.  Recipient may not sell, rent, lease, or sublicense
 *       this software.  Recipient may, however enable another person
 *       or entity the rights to use this software, provided that this
 *       AGREEMENT and NOTICE is furnished along with the software and
 *       /or software system utilizing this software.
 * 
 *       All revisions, modifications, created by the Recipient, to this
 *       software and/or related technical data shall be forwarded by the 
 *       Recipient to the Government at the following address:
 * 
 *         SMDC
 *         Attention SEDRIS (TO193) TPOC
 *         P.O. Box 1500
 *         Hunstville, AL  35807-3801
 * 
 *         or via electronic mail to:  se-mgmt@sedris.org
 * 
 *    5. No Warranty. This software is being delivered to you AS IS
 *       and there is no warranty, EXPRESS or IMPLIED, as to its use
 *       or performance.
 * 
 *       The RECIPIENT ASSUMES ALL RISKS, KNOWN AND UNKNOWN, OF USING
 *       THIS SOFTWARE.  The DEVELOPER EXPRESSLY DISCLAIMS, and the
 *       RECIPIENT WAIVES, ANY and ALL PERFORMANCE OR RESULTS YOU MAY
 *       OBTAIN BY USING THIS SOFTWARE OR DOCUMENTATION.  THERE IS
 *       NO WARRANTY, EXPRESS OR, IMPLIED, AS TO NON-INFRINGEMENT OF
 *       THIRD PARTY RIGHTS, MERCHANTABILITY, OR FITNESS FOR ANY
 *       PARTICULAR PURPOSE.  IN NO EVENT WILL THE DEVELOPER, THE
 *       UNITED STATES GOVERNMENT OR ANYONE ELSE ASSOCIATED WITH THE
 *       DEVELOPMENT OF THIS SOFTWARE BE HELD LIABLE FOR ANY CONSEQUENTIAL,
 *       INCIDENTAL OR SPECIAL DAMAGES, INCLUDING ANY LOST PROFITS
 *       OR LOST SAVINGS WHATSOEVER.
 */

/*
 * COPYRIGHT 2007, SCIENCE APPLICATIONS INTERNATIONAL CORPORATION.
 *                 ALL RIGHTS RESERVED.
 * 
 */

// SRM_OTHERS_GOES_HERE

/**
@author David Shen
*/

package org.sedris;

import java.util.*;

public class Bfs
{
    private static Bfs _bfs = new Bfs();

    public static Bfs instance() {
	return  _bfs;
    }

    public Vector GetConversionPath(SRM_SRFT_Code source, SRM_SRFT_Code destination)
    {
	boolean[] visited_node = new boolean[SRM_SRFT_Code._totalEnum+1];
	SRM_SRFT_Code[] parent_node = new SRM_SRFT_Code[SRM_SRFT_Code._totalEnum+1];
	int[] distance = new int[SRM_SRFT_Code._totalEnum+1];
	Vector lococentre = new Vector();
	Vector path = new Vector();
	Vector returnPath = new Vector();
	SRM_SRFT_Code current_node;
	SRM_SRFT_Code node;
	Conversions conv;

	for (int i=0; i<=SRM_SRFT_Code._totalEnum ; i++) {
	    visited_node[i] = false;
	    parent_node[i] = SRM_SRFT_Code.SRFT_UNDEFINED;
	    distance[i] = -1;
	}
	
	if (source != destination) {
	    visited_node[source.toInt()] = true;
	    distance[source.toInt()] = 0;
	    queue(lococentre, source);
	    
	    while (!lococentre.isEmpty()) {

		current_node = dequeue(lococentre);
	    
		if (current_node == destination) {
	      
		    node = current_node;

		    do {
			queue(path, node);
			node = parent_node[node.toInt()];
		    } while (node != source);
		    queue(path, node);
	      
		    for (int i=0; i<path.size(); i++)
			returnPath.insertElementAt(path.elementAt(i), 0);

// 		    System.out.println("PATH=> " + returnPath + ", distance=> " + distance[destination.toInt()]);
		
		    return returnPath;
		}
	    
		int index = 0;
		if ((conv = (Conversions)FunctionMap.instance().get(current_node)) != null)
		    node = (SRM_SRFT_Code)conv.getDest()[index];
		else
		    node = SRM_SRFT_Code.SRFT_UNDEFINED;
		while (node != SRM_SRFT_Code.SRFT_UNDEFINED) {
		    if (!visited_node[node.toInt()]) {
			queue(lococentre, node);
			visited_node[node.toInt()] = true;
			distance[node.toInt()] = distance[current_node.toInt()]+1;
			parent_node[node.toInt()] = current_node;
		    }

		    visited_node[current_node.toInt()] =  true;
		    if ((conv = (Conversions)FunctionMap.instance().get(current_node)) != null)
			node = (SRM_SRFT_Code)conv.getDest()[index++];
		    else
			node = SRM_SRFT_Code.SRFT_UNDEFINED;
		}
	    
	    }
	}

	// if source == destination
	else {
	    boolean firstRound = true;
	    distance[source.toInt()] = 0;
	    queue(lococentre, source);
	    
	    while (!lococentre.isEmpty()) {

		current_node = dequeue(lococentre);
	    
		// to check against when the source node and the target node are from the same SRF
		if (current_node == destination && !firstRound) {
	      
		    node = current_node;

		    //		    System.out.print("=> Parent Array=> " );
// 		    for (int i=0; i<parent_node.length; i++)
// 			System.out.print(parent_node[i] + ", ");
// 		    System.out.println("");


		    do {
			queue(path, node);

			//			System.out.println("PATH=> " + path);

			node = parent_node[node.toInt()];
		    } while (node != source);
		    queue(path, node);
	      
		    // reverse the order of the vector elements from source to target
		    for (int i=0; i<path.size(); i++)
			returnPath.insertElementAt(path.elementAt(i), 0);

// 		    System.out.println("PATH=> " + returnPath + ", distance=> " + distance[destination.toInt()]);
		
		    return returnPath;
		}
	    
		firstRound = false;

		int index = 0;
		if ((conv = (Conversions)FunctionMap.instance().get(current_node)) != null)
		    node = (SRM_SRFT_Code)conv.getDest()[index];
		else
		    node = SRM_SRFT_Code.SRFT_UNDEFINED;
		while (node != SRM_SRFT_Code.SRFT_UNDEFINED) {
		    if (!visited_node[node.toInt()]) {
			queue(lococentre, node);
			//			System.out.println("lococentre=> " + lococentre);
			visited_node[node.toInt()] = true;
			distance[node.toInt()] = distance[current_node.toInt()]+1;
			parent_node[node.toInt()] = current_node;

			// 		    System.out.print("=> Parent Array=> " );
			// 		    for (int i=0; i<parent_node.length; i++)
			// 			System.out.print(parent_node[i] + ", ");
			// 		    System.out.println("");
		    }
		
		    if (current_node != source)
			visited_node[current_node.toInt()] =  true;
		    if ((conv = (Conversions)FunctionMap.instance().get(current_node)) != null)
			node = (SRM_SRFT_Code)conv.getDest()[index++];
		    else
			node = SRM_SRFT_Code.SRFT_UNDEFINED;
		}
	    
	    }
	}
	
	// no path found from source to target
	return null;
	
    }
	
        
    private void queue (Vector lococentre, SRM_SRFT_Code node)
    {
	lococentre.add(node);
    }

    private SRM_SRFT_Code dequeue(Vector lococentre)
    {
	return ((SRM_SRFT_Code) lococentre.remove(0));
    }

//     public void main(String[] arg) {
//  	Vector v;
// 	for (int i=0; i<SRM_SRFT_Code._totalEnum; i++)
// 	    for (int j=0; j<SRM_SRFT_Code._totalEnum; j++) {
// 		System.out.println("*** From " + SRM_SRFT_Code._enumList[i].toString() + 
// 				 " to " + SRM_SRFT_Code._enumList[j].toString());
// 		v= GetConversionPath(SRM_SRFT_Code._enumList[i], SRM_SRFT_Code._enumList[j]);
// 	    }
// 	System.out.println("Path from " + SRM_SRFT_Code.SRFT_LOCAL_TANGENT_SPACE_CYLINDRICAL + " to " +
// 			   SRM_SRFT_Code.SRFT_LOCAL_TANGENT_SPACE_CYLINDRICAL );
// 	v = GetConversionPath(SRM_SRFT_Code.SRFT_LOCAL_TANGENT_SPACE_CYLINDRICAL, SRM_SRFT_Code.SRFT_LOCAL_TANGENT_SPACE_CYLINDRICAL);
// 	for ( int i=0; i<v.size(); i++ )
// 	    System.out.println("Node " + i + " => " + v.elementAt(i) );
//     }
	    
}
