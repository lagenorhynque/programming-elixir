defmodule MyEnum do
  def all?(list, fun \\ &(&1))
  def all?([], _), do: true
  def all?([head | tail], fun), do: !!fun.(head) and all?(tail, fun)

  def each([], _), do: :ok
  def each([head | tail], fun) do
    fun.(head)
    each(tail, fun)
  end

  def filter([], _), do: []
  def filter([head | tail], fun) do
    if fun.(head) do
      [head | filter(tail, fun)]
    else
      filter(tail, fun)
    end
  end

  def split([], _), do: {[], []}
  def split(list, count) when count == 0, do: {[], list}
  def split([head | tail], count) when count > 0 do
    {first, rest} = split(tail, count - 1)
    {[head | first], rest}
  end
  def split(list, count) when count < 0, do: split(list, max(0, length(list) + count))

  def take([], _), do: []
  def take(_, amount) when amount == 0, do: []
  def take([head | tail], amount) when amount > 0, do: [head | take(tail, amount - 1)]
  def take(list, amount) when amount < 0,
    do: list |> Enum.reverse |> take(-amount) |> Enum.reverse
end
