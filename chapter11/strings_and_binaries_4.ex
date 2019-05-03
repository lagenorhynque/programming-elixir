defmodule Calculator do
  def calculate(cs) do
    [x, op, y] = cs |> to_string |> String.split
    _calculate(String.to_integer(x), op, String.to_integer(y))
  end

  defp _calculate(x, "+", y), do: x + y
  defp _calculate(x, "-", y), do: x - y
  defp _calculate(x, "*", y), do: x * y
  defp _calculate(x, "/", y), do: x / y
end
