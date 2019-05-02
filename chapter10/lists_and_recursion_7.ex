defmodule Primes do
  defp span(from, to) when from > to, do: []
  defp span(from, to), do: [from | span(from + 1, to)]

  def primes(n) do
    for x <- span(2, n), Enum.all?(span(2, :math.sqrt(x)), &(rem(x, &1) != 0)), do: x
  end
end
