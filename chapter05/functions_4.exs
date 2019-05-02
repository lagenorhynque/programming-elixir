prefix = fn(p) ->
  fn(s) -> "#{p} #{s}" end
end

mrs = prefix.("Mrs")
mrs.("Smith")
prefix.("Elixir").("Rocks")
