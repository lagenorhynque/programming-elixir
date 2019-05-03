defmodule OrdersFromFile do
  @default_order_file "./order.csv"

  def read_from_csv(order_file \\ @default_order_file) do
    case File.open(order_file) do
      {:ok, file} ->
        {[header], rows} = file
        |> IO.stream(:line)
        |> Enum.split(1)

        header_cols = header |> csv_row_to_cols |> Enum.map(&String.to_atom/1)

        Enum.map(rows, fn(line) ->
          line
          |> csv_row_to_cols
          |> columns_to_order(header_cols)
        end)
      _ -> IO.puts "No such file found: #{order_file}"
    end
  end

  defp csv_row_to_cols(row), do: row |> String.trim |> String.split(",")

  defp columns_to_order([id, <<_::utf8, ship_to::binary>>, net_amount], header_cols),
    do: Enum.zip(header_cols,
          [String.to_integer(id), String.to_atom(ship_to), String.to_float(net_amount)])
end
