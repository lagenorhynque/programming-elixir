defmodule PrintableCharacters do
  def printable_ascii_characters?(cs), do: Enum.all?(cs, &(&1 in ?\s..?~))
end
