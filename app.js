const apiBase = '/api';
const $ = (id) => document.getElementById(id);
const out = (id, data) => { $(id).textContent = typeof data === 'string' ? data : JSON.stringify(data, null, 2); };

function showSection(sectionId){
  document.querySelectorAll('.section').forEach(s => s.classList.remove('active'));
  document.getElementById(sectionId).classList.add('active');
}

document.querySelectorAll('.nav-btn').forEach(btn => {
  btn.addEventListener('click', () => showSection(btn.dataset.section));
});

async function postJson(url, body){
  const res = await fetch(url, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(body)
  });
  const text = await res.text();
  let data;
  try { data = JSON.parse(text); } catch { data = text; }
  if(!res.ok) throw data;
  return data;
}

async function getJson(url){
  const res = await fetch(url);
  const text = await res.text();
  let data;
  try { data = JSON.parse(text); } catch { data = text; }
  if(!res.ok) throw data;
  return data;
}

$('btnCreateStudent').addEventListener('click', async () => {
  try{
    const student = {
      fullName: $('studentName').value.trim(),
      cgpa: Number($('studentCgpa').value),
      email: $('studentEmail').value.trim()
    };
    const data = await postJson(`${apiBase}/students`, student);
    out('outStudentCreate', data);
  }catch(e){ out('outStudentCreate', {error:e}); }
});

$('btnEligibility').addEventListener('click', async () => {
  try{
    const studentId = Number($('eligStudentId').value);
    const minCgpa = Number($('eligMinCgpa').value);
    const data = await postJson(`${apiBase}/students/${studentId}/eligibility`, { minCgpa });
    out('outEligibility', data);
  }catch(e){ out('outEligibility', {error:e}); }
});

$('btnCreateCompany').addEventListener('click', async () => {
  try{
    const company = { companyName: $('companyName').value.trim() };
    const data = await postJson(`${apiBase}/companies`, company);
    out('outCompanyCreate', data);
  }catch(e){ out('outCompanyCreate', {error:e}); }
});

$('btnCreatePlacement').addEventListener('click', async () => {
  try{
    const placement = {
      studentId: Number($('placeStudentId').value),
      companyId: Number($('placeCompanyId').value),
      status: $('placeStatus').value,
      notes: $('placeNotes').value.trim()
    };
    const data = await postJson(`${apiBase}/placements`, placement);
    out('outPlacementCreate', data);
  }catch(e){ out('outPlacementCreate', {error:e}); }
});

$('btnStats').addEventListener('click', async () => {
  try{
    const data = await getJson(`${apiBase}/analytics/stats`);
    out('outStats', data);
  }catch(e){ out('outStats', {error:e}); }
});

