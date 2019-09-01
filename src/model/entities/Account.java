package model.entities;

import model.exceptions.DomainException;

public class Account {
	private int numberAccount;
	private String nameHolder;
	private double inicialBalance;
	private double withdrawLimite;

	public Account() {
	}

	public Account(int numberAccount, String nameHolder, double inicialBalance, double withdrawLimite) {
		if (inicialBalance < 0) {
			throw new DomainException("Not enough balance");
		}
		
		if (withdrawLimite < 0) {
			throw new DomainException("Not enough withdraw");
		}
		
		this.numberAccount = numberAccount;
		this.nameHolder = nameHolder;
		this.inicialBalance = inicialBalance;
		this.withdrawLimite = withdrawLimite;
	}

	public int getNumberAccount() {
		return numberAccount;
	}

	public String getNameHolder() {
		return nameHolder;
	}

	public void setNameHolder(String nameHolder) {
		this.nameHolder = nameHolder;
	}

	public double getInicialBalance() {
		return inicialBalance;
	}

	public double getWithdrawLimite() {
		return withdrawLimite;
	}

	public void withdraw(double amount) {
		if (amount > inicialBalance) {
			throw new DomainException("Not enough balance");
		}
		
		if (amount > withdrawLimite) {
			throw new DomainException("The amount exceeds withdraw limit");
		}

		inicialBalance -= amount;
	}
}
