package com.platform.croudsource.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MinPay {

	private ArrayList<User> users;
	private ArrayList<Mission> tasks;
	private ArrayList<Double> pays;

	public List<User> getUserList(ArrayList<User> users, ArrayList<Mission> missions){
		this.users = users;
		tasks = deepCopy(missions);
		pays = new ArrayList<Double>();
		step1();
		step2();
		for(int i = 0; i < users.size(); i++){
			users.get(i).setPay(pays.get(i));
		}

		return this.users;
	}

	public ArrayList<Mission> deepCopy(ArrayList<Mission> arr){
		ArrayList<Mission> ret = new ArrayList<Mission>();
		for(Iterator it = arr.iterator(); it.hasNext(); ){
			ret.add(new Mission((Mission)it.next()));
		}
		return ret;
	}

	/*
	 * ����1���������
	 * ���������endUers�е��û������������˳�����½���������
	 */
	public void step1(){
		ArrayList<Mission> locTasks = deepCopy(tasks);
		for(int i=0; i<users.size(); ++i){
			int chosenUser = chooseUser(users, i, locTasks);
			assignUserJob(users.get(chosenUser), locTasks);
			swapUser(users, i, chosenUser);
		}
	}

	/*
	 * ����localUsers�����е�����Ԫ��
	 */
	public void swapUser(ArrayList<User> users,int i, int j)
	{
		if(i == j)
			return;
		User u = users.get(i);
		users.set(i , users.get(j));
		users.set(j, u );
	}

	/*
	 * ѡ��һ������ƽ��������С���û���users[startInd]��ʼ
	 */
	public int chooseUser(ArrayList<User> users, int startInd, ArrayList<Mission> tasks){
		int ret = startInd;
		double minScore = safeDivide(users.get(ret).getBid(), phiOfUser(users.get(ret), tasks));
		for(int i=ret+1; i<users.size(); ++i){
			double tmpScore = safeDivide(users.get(i).getBid(), phiOfUser(users.get(i), tasks));
			if(tmpScore < minScore){
				minScore = tmpScore;
				ret = i;
			}
		}
		return ret;
	}

	/*
	 * ���������������Ϊ0�򷵻�MAXֵ
	 */
	double safeDivide(double d1, double d2){
		if(d2==0)
			return Double.MAX_VALUE;
		else
			return d1/d2;
	}

	/*
	 * ����user�û���phiֵ
	 */
	public int phiOfUser(User user, ArrayList<Mission> tasks){
		int ret = 0;
		for(Iterator it=user.getS().iterator(); it.hasNext();){
			int taskID = (Integer)it.next();
			Mission t;
			if( (t = taskOfID(taskID, tasks)) != null){
				if(t.getTimes()>0)
					ret += t.getValue();
			}
		}
		return ret;
	}

	public Mission taskOfID(int id, ArrayList<Mission> tasks){
		for(Iterator it=tasks.iterator(); it.hasNext();){
			Mission tmp = (Mission)it.next();
			if(tmp.getId() == id)
				return tmp;
		}
		return null;
	}

	/*
	 * ��user���������񼯷������
	 */
	public void assignUserJob(User user, ArrayList<Mission> tasks){
		for(Iterator it = user.getS().iterator(); it.hasNext();){
			int taskID = (Integer)it.next();
			Mission t;
			if( (t = taskOfID(taskID, tasks)) != null){
				if(t.getTimes()>0)
					t.setTimes(t.getTimes()-1);
			}
		}
	}


	/*
	 * ����2��֧������
	 */
	public void step2()
	{
		for(int i=0; i<users.size(); ++i){
			ArrayList<User> locUsers = new ArrayList<User>(users);
			ArrayList<Mission> locTasks = deepCopy(tasks);
			swapUser(locUsers, 0, i);

			double pay = calPay(locUsers, locTasks);
			//System.out.printf("i:%d,pay:%d\n", i, pay);
			pays.add(pay);
		}
	}

	/*
	 * ����localUsers[0]��֧���۸�
	 */
	double calPay(ArrayList<User> users, ArrayList<Mission> tasks){
		double ret = 0;
		for(int i=1; i<users.size(); ++i){
			int chosenUser = chooseUser(users, i, tasks);
			swapUser(users, i, chosenUser);
			double tmp = phiOfUser(users.get(0), tasks)/(phiOfUser(users.get(i), tasks)*1.0/users.get(i).getBid());
			if(tmp>ret)
				ret = tmp;
			assignUserJob(users.get(i), tasks);
		}
		double tmp = phiOfUser(users.get(0), tasks);
		if(tmp>ret)
			ret = tmp;
		return ret;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		ArrayList<User> users = new ArrayList<User>();
//		users.add(new User(){{setId(1); setBid(5); setS(new ArrayList<Integer>(){{add(1);add(3);add(9);}});}});
//		users.add(new User(){{setId(2); setBid(8); setS(new ArrayList<Integer>(){{add(1);add(4);add(5);}});}});
//		users.add(new User(){{setId(3); setBid(6); setS(new ArrayList<Integer>(){{add(2);add(4);}});}});
//
//		ArrayList<Task> tasks = new ArrayList<Task>();
//		tasks.add(new Task(){{setId(1); setValue(6); setTimes(1);}});
//		tasks.add(new Task(){{setId(2); setValue(7); setTimes(1);}});
//		tasks.add(new Task(){{setId(3); setValue(6); setTimes(1);}});
//		tasks.add(new Task(){{setId(4); setValue(8); setTimes(1);}});
//		tasks.add(new Task(){{setId(5); setValue(9); setTimes(1);}});
//
//		//����ַ��㷨ʵ��
//		JobDistribute jd = new JobDistribute(users, tasks);
//
//		//�������
//		jd.step1();
//
//		//֧������
//		jd.step2();
//
//		//jd.endUsers��Ϊ�ź�����û�����
//		for(int i=0; i<jd.users.size(); ++i)
//		{
//			System.out.printf("%d, %f \n",jd.users.get(i).getId(),jd.pays.get(i));
//		}
//	}

}
