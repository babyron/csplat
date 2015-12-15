package com.platform.croudsource.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UCBQA {

	public double quality(double[] ppro, double[] tpro) {
		for(int i = 0; i < 8; i++){
			if(ppro[i] < tpro[i]) return 0;
		}
		return 1;
	}

	public double[][] matrixPlus(double[][] a, double[][] b) {
		double[][] c = new double[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}

	public double[] matrixPlus(double[] a, double[] b) {
		double[] c = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i] + b[i];
		}
		return c;
	}

	public double[][] matrixMultiply(double[][] a, double[][] b) {
		double[][] c = new double[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				double temp = 0;
				for (int k = 0; k < b.length; k++) {
					temp += a[i][k] * b[k][j];
				}
				c[i][j] = temp;
			}
		}
		return c;
	}

	public double[] matrixMultiply(double[][] a, double[] b) {
		double[] c = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			double temp = 0;
			for (int j = 0; j < b.length; j++) {
				temp += a[i][j] * b[j];
			}
			c[i] = temp;
		}
		return c;
	}

	public double[] matrixMultiply(double[] a, double[][] b) {
		double[] c = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			double temp = 0;
			for (int j = 0; j < b.length; j++) {
				temp += a[i] * b[j][i];

			}
			c[i] = temp;
		}
		return c;
	}

	public double matrixMultiply(double[] a, double[] b) {
		double c = 0;
		for (int i = 0; i < a.length; i++) {
			c += a[i] * b[i];
		}
		return c;
	}

	public double[][] matrixMultiply(double[] a, double[] b, int z) { // 列向量乘以行向量
		double[][] c = new double[a.length][b.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				c[i][j] = a[i] * b[j];
			}
		}
		return c;
	}

	public double[] matrixMultiply(double a, double[] b) { // q*X
		double[] c = new double[b.length];
		for (int i = 0; i < b.length; i++) {
			c[i] = a * b[i];
		}
		return c;
	}

	public double[][] matrixTransposition(double[][] a) {
		double[][] c = new double[a[0].length][a.length];
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				c[i][j] = a[j][i];
			}
		}
		return c;
	}

	public double[][] matrixInv(double[][] matrix) {
		int n = matrix.length;
		double[][] matrix1 = new double[n][2 * n];
		double[][] result = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix1[i][j] = matrix[i][j];
			}
		}
		for (int k = 0; k < n; k++) {
			for (int t = n; t < n * 2; t++) {
				if ((t - k) == n) {
					matrix1[k][t] = 1.0;
				} else {
					matrix1[k][t] = 0;
				}
			}
		}
		// get the change of the array
		for (int k = 0; k < n; k++) {
			if (matrix1[k][k] != 1) {
				double bs = matrix1[k][k];
				matrix1[k][k] = 1;
				for (int p = k; p < n * 2; p++) {
					matrix1[k][p] /= bs;
				}
			}
			for (int q = 0; q < n; q++) {
				if (q != k) {
					double bs = matrix1[q][k];
					for (int p = 0; p < n * 2; p++) {
						matrix1[q][p] -= bs * matrix1[k][p];
					}
				} else {
					continue;
				}
			}
		}
		for (int x = 0; x < n; x++) {

			for (int y = n; y < n * 2; y++) {
				result[x][y - n] = matrix1[x][y];
			}
		}

		return result;
	}

	public boolean isLocated(User i, Mission k){    //判断地理位置是否符合
		int r = 100;
		double temp1, temp2, temp3;
		temp1 = (i.getX() - k.getX());
		temp2 = temp1 * temp1;
		temp1 = (i.getY() - k.getY());
		temp3 = temp1 * temp1;
		temp1 = Math.sqrt(temp2 + temp3);
		if(r < temp1) return true;
		else return false;
	}


	public List<User> Calculation(ArrayList<User> peo, ArrayList<Mission> task,
							double alp, int len, double budget) {
		//budget 需求者的总预算
		//alp 权衡开发和探索的权重
		int num = 0;    //high quality
		int totalnum = 0; //observe times
		double reward = 0;

		int i = 0;

		for(i = 0; i < task.size(); i++){
			if(reward > budget) break;
			int tlen = 8;
			double[] x = new double[8];   					//将task的属性转为double数组
			for(int j = 0; j < tlen; j++){
				x[j] = task.get(i).getProperty()[j];
			}

			ArrayList<User> temp = new ArrayList<User>();  //Users who checks in at this POI


			for(int j = 0; j < peo.size(); j++){
				if(isLocated(peo.get(j), task.get(i))) temp.add(peo.get(j));
			}

			double rewardtmp = 0;


			ArrayList<User> selected = new ArrayList<User>();
			for(int l = 0; rewardtmp <= task.get(i).getBudget() ; l++){
				task.get(i).setRemainbudget(task.get(i).getBudget()-rewardtmp);
				double max = 0;
				int tempid = 0;
				int peoid = 0;
				for (int j = 0; j < temp.size(); j++) {
					temp.get(j).setTheta(matrixMultiply(matrixInv(temp.get(j).getA()),temp.get(j).getB()));

					double temp1 = matrixMultiply(temp.get(j).getTheta(), x);  //x为任务属性

					double[] temp2 = matrixMultiply(x, matrixInv(temp.get(j).getA()));

					double temp3 = matrixMultiply(temp2, x);

					double temp4 = alp * Math.sqrt(temp3);

					double t = temp1 + temp4;

					if (t > max) {
						max = t;
						tempid = j;					//the biggest index's id in temp 

					}
				}
//				peoid = temp.get(tempid).getId();    //找到在参与者中使式子达到最大的id

				selected.add(temp.get(tempid));

				temp.get(tempid).setA(matrixPlus(temp.get(tempid).getA(), matrixMultiply(x, x, 1)));

				double q = quality(temp.get(tempid).getProperty(), x);

				//totalnum++;
				rewardtmp = rewardtmp + task.get(i).getPay();

				temp.get(tempid).setB(matrixPlus(temp.get(tempid).getB(), matrixMultiply(q, x)));

				if (q == 1){
					task.get(i).setSuccess(task.get(i).getSuccess()+1);
					num++;
					//temp.get(tempid).qcnt++;
				}
				else{
					task.get(i).setFailure(task.get(i).getFailure()+1);
				}

				//temp.get(tempid).tcnt++;	
				if(task.get(i).getSuccess() == task.get(i).getTimes()){
					break;
				}
			}
			reward += rewardtmp;
			
			
			/*selected是当前任务选中的用户集*/
			//在此输出
			//new View().viewSelected(selected, task.get(i));
			return selected;

		}
		//double temp = (double)(num) / (double)totalnum;

		return null;
		//return totalnum;
	}

}
