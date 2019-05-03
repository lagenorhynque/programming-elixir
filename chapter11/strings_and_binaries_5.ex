defmodule PrettyPrinter do
  def center(ss) do
    lengths = Enum.map(ss, &String.length/1)
    max_length = Enum.max(lengths)
    ss
    |> Enum.map(fn(s) ->
      length = String.length(s)
      pad_size = div(max_length - length, 2)
      s |> String.pad_leading(pad_size + length) |> String.pad_trailing(max_length)
    end)
    |> Enum.each(&IO.puts/1)
  end
end
