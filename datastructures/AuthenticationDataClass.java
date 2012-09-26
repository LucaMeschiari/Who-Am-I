package com.cs7048.simulation.datastructures;

import java.util.ArrayList;

public class AuthenticationDataClass implements AuthenticationData {

	private static final long serialVersionUID = -4434106899357760458L;
	public String userId;
	public boolean altAuth = true;
	public ArrayList<NodeRelationsClass> nodeRelations;
	public int type = 0; // 1

	public AuthenticationDataClass(String rUserId,
			NodeRelationsClass rNodeRelations[]) {
		userId = rUserId;
		nodeRelations = new ArrayList<NodeRelationsClass>();
		for (NodeRelationsClass i : rNodeRelations) {
			nodeRelations.add(i);
		}
	}

	public AuthenticationDataClass(String rUserId) {
		userId = rUserId;
		nodeRelations = new ArrayList<NodeRelationsClass>();
	}

	public void addNodeRelation(NodeRelationsClass rNodeRelation) {
		nodeRelations.add(rNodeRelation);
	}

	public String getClaimedUserId() {
		return userId;
	}

	@Override
	public NodeRelationsClass[] getNodeRelationsArray() {
		return nodeRelations.toArray(new NodeRelationsClass[0]);
	}

	public NodeRelationsClass getNodeRelationAtIndex(int i) {
		return nodeRelations.get(i);
	}

	public int returnNumberRelationships() {
		return nodeRelations.size();
	}

	public void shiftListLeft(int n) {
		for (int i = 0; i < n; i++) {
			nodeRelations.remove(0);
		}
	}

	// Change always the first node of the relationship
	public void DeviateNode(int pos, int newNode, Float firstInterval,
			Float secondInterval) {
		NodeRelationsClass secondRelation = nodeRelations.remove(pos);
		NodeRelationsClass tempNodeRelation2 = new NodeRelationsClass(newNode,
				secondRelation.secondNode, secondInterval);
		nodeRelations.add(pos, tempNodeRelation2);

		if (pos > 0) {
			NodeRelationsClass firstRelation = nodeRelations.remove(pos - 1);
			NodeRelationsClass tempNodeRelation1 = new NodeRelationsClass(
					firstRelation.firstNode, newNode, firstInterval);
			nodeRelations.add(pos - 1, tempNodeRelation1);
		}

	}

	public void changeIntervalRelation(int pos, Float interval) {
		NodeRelationsClass relation = nodeRelations.remove(pos);
		NodeRelationsClass tempNodeRelation = new NodeRelationsClass(
				relation.firstNode, relation.secondNode, interval);
		nodeRelations.add(pos, tempNodeRelation);

	}

	public String toString() {
		String retString = String.format("User: %s AltAuth: %s Type %d  \n",
				userId, altAuth, type);
		StringBuilder strBuild = new StringBuilder(retString);
		for (NodeRelationsClass rel : nodeRelations) {
			strBuild.append(rel.toString());
			// System.out.println(retString);
		}
		return strBuild.toString();
	}

	public void setAltAuth(boolean rAuth) {
		altAuth = rAuth;
	}

	public boolean retAltAuth() {
		return altAuth;
	}

	public void setType(int rType) {
		type = rType;
	}

	public int retType() {
		return type;
	}

}
