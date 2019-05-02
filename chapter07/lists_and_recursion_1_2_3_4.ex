defmodule MyList do
  def mapsum(list, func), do: _mapsum(list, func, 0)

  defp _mapsum([], _, acc), do: acc
  defp _mapsum([head | tail], func, acc),
    do: _mapsum(tail, func, func.(head) + acc)

  def max([head | tail]), do: _max(tail, head)

  defp _max([], acc), do: acc
  defp _max([head | tail], acc) when head > acc, do: _max(tail, head)
  defp _max([_ | tail], acc), do: _max(tail, acc)

  def caesar([], _), do: []
  def caesar([head | tail], n) when head + n > ?z,
    do: [head + n - (?z - ?a + 1) | caesar(tail, n)]
  def caesar([head | tail], n), do: [head + n | caesar(tail, n)]

  def span(from, to) when from > to, do: []
  def span(from, to), do: [from | span(from + 1, to)]
end
