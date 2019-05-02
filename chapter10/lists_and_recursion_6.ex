defmodule MyList do
  def flatten(list), do: _flatten(list, [])

  defp _flatten([], acc), do: Enum.reverse(acc)
  defp _flatten([head | tail], acc) when is_list(head), do: _flatten(head, acc) ++ _flatten(tail, [])
  defp _flatten([head | tail], acc), do: _flatten(tail, [head | acc])
end
