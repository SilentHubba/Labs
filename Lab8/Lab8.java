package labs;

public class Lab8 {
	public int coinChange(int[] coins, int amount) {
		int[] numCoins = new int[amount + 1];
		
		for(int i = 1; i < amount + 1; i++)
		{
			int minCoins = Integer.MAX_VALUE;
			for(int j = 0; j < coins.length; j++)
			{
				if(i - coins[j] >= 0 && numCoins[i - coins[j]] != Integer.MAX_VALUE)
				{
					minCoins = Math.min(minCoins, numCoins[i - coins[j]] + 1);
				}
			}
			numCoins[i] = minCoins;
		}
		if(numCoins[amount] == Integer.MAX_VALUE)
		{
			return -1;
		}
		
		return numCoins[amount];
	}
	
	public static void main(String[] args)
	{
		Lab8 coinChanger = new Lab8();
		int[] coins1 = {1, 2, 5};
		System.out.println(coinChanger.coinChange(coins1, 11));
		
		int[] coins2 = {2};
		System.out.println(coinChanger.coinChange(coins2, 3));

		int[] coins3 = {1};
		System.out.println(coinChanger.coinChange(coins3, 0));

	}
}
