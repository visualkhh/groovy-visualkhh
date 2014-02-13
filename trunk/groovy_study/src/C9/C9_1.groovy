package C9

byte[] data = new byte[256]
for (i in 0..255) { data[i] = i }

println data;

store = data.encodeBase64().toString()

println store;

println  ' store.startsWith(\'AAECAwQFBg\') : ' + store.startsWith('AAECAwQFBg')
println  ' store.endsWith  (\'r7/P3+/w==\') : ' + store.endsWith  ('r7/P3+/w==')

restored = store.decodeBase64()

assert data.toList() == restored.toList()