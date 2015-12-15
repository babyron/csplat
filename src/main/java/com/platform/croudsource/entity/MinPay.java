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
	 * 步骤1：任务分配
	 * 结果：数组endUers中的用户按照任务分配顺序重新进行了排序
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
	 * 交换localUsers数组中的两个元素
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
	 * 选择一个任务平均单价最小的用户，users[startInd]开始
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
	 * 两个数相除，除数为0则返回MAX值
	 */
	double safeDivide(double d1, double d2){
		if(d2==0)
			return Double.MAX_VALUE;
		else
			return d1/d2;
	}

	/*
	 * 计算user用户的phi值
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
	 * 将user所报的任务集分配给他
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
	 * 步骤2：支付计算
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
	 * 计算localUsers[0]的支出价格
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
//		//任务分发算法实例
//		JobDistribute jd = new JobDistribute(users, tasks);
//
//		//任务分配
//		jd.step1();
//
//		//支付计算
//		jd.step2();
//
//		//jd.endUsers中为排好序的用户对象
//		for(int i=0; i<jd.users.size(); ++i)
//		{
//			System.out.printf("%d, %f \n",jd.users.get(i).getId(),jd.pays.get(i));
//		}
//	}

}
