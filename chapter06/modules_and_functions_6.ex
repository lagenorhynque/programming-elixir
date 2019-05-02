defmodule Chop do
  def guess(actual, range = min..max) do
    helper(actual, range, average(min, max))
  end

  defp average(min, max), do: div(min + max, 2)

  defp helper(actual, min.._, expected)
  when actual < expected do
    IO.puts "Is it #{inspect expected}"
    helper(actual, min..(expected - 1), average(min, expected - 1))
  end

  defp helper(actual, _..max, expected)
  when actual > expected do
    IO.puts "Is it #{inspect expected}"
    helper(actual, (expected + 1)..max, average(expected + 1, max))
  end

  defp helper(actual, _, expected) when actual == expected, do: expected
end
