defmodule OK do
  def ok!({:ok, data}), do: data
  def ok!(error), do: raise RuntimeError, message: inspect(error)
end
