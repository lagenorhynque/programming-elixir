defmodule FizzBuzz do
  def upto(n) when n > 0, do: Enum.map(1..n, &fizzbuzz/1)

  defp fizzbuzz(n) do
    case {rem(n, 3), rem(n, 5)} do
      {0, 0} -> "FizzBuzz"
      {0, _} -> "Fizz"
      {_, 0} -> "Buzz"
      _ -> n
    end
  end
end
